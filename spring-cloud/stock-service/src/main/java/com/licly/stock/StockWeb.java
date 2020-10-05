package com.licly.stock;

import com.licly.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存
 *
 * @author licly
 * @date 2020/10/5
 */

@RestController
@RequestMapping("/v1/stock")
public class StockWeb {

    @PostMapping("/reduce")
    public Result reduceStock() {
        return Result.success();
    }
}
