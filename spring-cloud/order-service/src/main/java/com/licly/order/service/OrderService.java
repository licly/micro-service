package com.licly.order.service;

import com.licly.common.Result;
import com.licly.order.entity.Order.Order;
import com.licly.order.feign.CreditService;
import com.licly.order.feign.StockService;
import com.licly.order.feign.WmsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;

/**
 * 订单服务
 *
 * @author licly
 * @date 2020/10/6
 */

@Service
public class OrderService {

    @Resource
    private CreditService creditService;

    @Resource
    private WmsService wmsService;

    @Resource
    private StockService stockService;

    public Result placeOrder(Order order) {
        // 扣减库存
        stockService.reduceStock(order.getProductId(), order.getStockNum());
        // 通知仓储
        wmsService.inform(order.getProductId(), order.getAddress(), order.getStockNum());
        // 增加积分
        creditService.increaseCredit(order.getTotalPrice());

        return Result.success();
    }
}
