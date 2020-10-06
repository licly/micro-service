package com.licly.order.feign;

import com.licly.credit.CreditApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 积分服务feign客户端
 *
 * @author licly
 * @date 2020/10/6
 */

@Service
@FeignClient("credit-service")
public interface CreditService extends CreditApi {

}
