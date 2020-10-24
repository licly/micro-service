package com.licly.order.transaction;

import com.licly.order.service.OrderService;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/11
 */

@Component
public class OrderTransactionListenerImpl implements TransactionListener {

    @Resource
    private OrderService orderService;



    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        // orderService.placeOrder();
        return null;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        return null;
    }
}
