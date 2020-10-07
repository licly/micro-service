package com.licly.credit;

import com.licly.common.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 积分服务暴露API
 *
 * @author licly
 * @date 2020/10/6
 */

@RequestMapping("/v1/credit")
public interface CreditApi {

    @RequestMapping("/increaseCredit/{totalPrice}")
    Result increaseCredit(@PathVariable("totalPrice") Integer totalPrice);
}
