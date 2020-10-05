package com.licly.credit;

import com.licly.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 积分
 *
 * @author licly
 * @date 2020/10/5
 */

@RestController
@RequestMapping("/v1/credit")
public class CreditWeb {

    @PostMapping("/addCredit")
    public Result addCredit() {
        // 增加积分
        return Result.success();
    }
}
