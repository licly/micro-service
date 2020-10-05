package com.licly.order;

import com.licly.common.Result;
import com.licly.order.entity.Order.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单控制
 *
 * @author licly
 * @date 2020/10/5
 */

@RestController
@RequestMapping("/v1/order")
public class OrderWeb {

    @PostMapping("/placeOrder")
    public Result placeOrder(Order order) {
        // 扣减库存

        // 通知仓储

        // 增加积分

        return Result.success();
    }

}
