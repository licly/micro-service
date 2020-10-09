package com.licly.order.service;

import ch.qos.logback.core.util.TimeUtil;
import com.licly.annotation.Idempotent;
import com.licly.common.Result;
import com.licly.order.entity.Order.Order;
import com.licly.order.feign.CreditService;
import com.licly.order.feign.StockService;
import com.licly.order.feign.WmsService;
import com.licly.utils.SleepUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
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
