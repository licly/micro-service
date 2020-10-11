package com.licly.order.service;

import ch.qos.logback.core.util.TimeUtil;
import com.licly.annotation.Idempotent;
import com.licly.common.Result;
import com.licly.order.entity.Order.Order;
import com.licly.order.feign.CreditService;
import com.licly.order.feign.StockService;
import com.licly.order.feign.WmsService;
import com.licly.order.transaction.OrderTransactionListenerImpl;
import com.licly.utils.SleepUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 订单服务
 *
 * @author licly
 * @date 2020/10/6
 */

@Slf4j
@Service
public class OrderService {

    @Resource
    private CreditService creditService;

    @Resource
    private WmsService wmsService;

    @Resource
    private StockService stockService;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private OrderTransactionListenerImpl transactionListener;

    public void sendMsg() throws MQClientException, UnsupportedEncodingException {
        TransactionMQProducer producer = new TransactionMQProducer("licly-transaction-test");
        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2000), r -> {
            Thread thread = new Thread(r);
            thread.setName("client-transaction-msg-check-thread");
            return thread;
        });
        producer.setExecutorService(executorService);
        producer.setTransactionListener(transactionListener);
        producer.start();

        Message msg = new Message("TopicTest1234", "test-transaction-msg".getBytes(RemotingHelper.DEFAULT_CHARSET));
        TransactionSendResult sendResult = producer.sendMessageInTransaction(msg, null);

        if (SendStatus.SEND_OK.equals(sendResult.getSendStatus())) {
            
        }
    }

    @Idempotent
    @Transactional(rollbackFor = Exception.class)
	public Result placeOrder(Order order) {
        System.out.println("into");
        SleepUtils.sleep(1000);
        // 扣减库存
        stockService.reduceStock(order.getProductId(), 0);
        // 通知仓储
        wmsService.inform(order.getProductId(), order.getAddress(), 0);
        // 增加积分
        creditService.increaseCredit(order.getTotalPrice());

	    log.info("完成订单！");
	    String key = order.getOrderId() + order.getProductId();
	    if (redisTemplate.opsForValue().get(key) != null) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        } else {
	        redisTemplate.opsForValue().set(key, order.getOrderId());
        }
        return Result.success();
    }

    public void rollback() {
        log.info("已回滚！");
    }
}
