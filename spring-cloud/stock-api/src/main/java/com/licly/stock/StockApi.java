package com.licly.stock;

import com.licly.common.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 库存服务暴露接口
 *
 * @author licly
 * @date 2020/10/6
 */

@RequestMapping("/v1/stock")
public interface StockApi {

    /**
     * 减库存
     * @param productId 商品id
     * @param StockNum 减少的库存量
     * @return 处理结果
     */
    @RequestMapping("/reduceStock/{productId}/{stockNum}")
    Result reduceStock(@PathVariable("productId") String productId, @PathVariable("stockNum") Integer StockNum);
}
