package com.licly.order;

import com.licly.common.Result;
import com.licly.order.entity.Order.Order;
import com.licly.order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单控制
 *
 * @author licly
 * @date 2020/10/5
 */

@RestController
@RequestMapping("/v1/order")
public class OrderWeb {

    @Resource
    private OrderService service;

    @PostMapping("/placeOrder")
    public Result placeOrder(@RequestBody Order order) {
        return service.placeOrder(order);
    }

}
