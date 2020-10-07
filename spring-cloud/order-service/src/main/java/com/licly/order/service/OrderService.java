package com.licly.order.service;

import com.licly.common.Result;
import com.licly.order.entity.Order.Order;
import com.licly.order.feign.CreditService;
import com.licly.order.feign.StockService;
import com.licly.order.feign.WmsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

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

	public Result placeOrder(Order order) {
        // 扣减库存
        stockService.reduceStock(order.getProductId(), 0);
        // 通知仓储
        wmsService.inform(order.getProductId(), order.getAddress(), 0);
        // 增加积分
        creditService.increaseCredit(order.getTotalPrice());

	    log.info("完成订单！");
        return Result.success();
    }
}
