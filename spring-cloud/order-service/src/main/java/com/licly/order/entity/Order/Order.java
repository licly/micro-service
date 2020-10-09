package com.licly.order.entity.Order;

import lombok.Getter;
import lombok.Setter;

/**
 * 订单
 *
 * @author licly
 * @date 2020/10/5
 */

@Setter
@Getter
public class Order {

    private String OrderId;

    private String productId;

    private Integer stockNum;

    private String address;

    private Integer totalPrice;
}
