package com.licly.order.feign;

import com.licly.stock.StockApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/6
 */

@Component
@FeignClient("stock-service")
public interface StockService extends StockApi {
}
