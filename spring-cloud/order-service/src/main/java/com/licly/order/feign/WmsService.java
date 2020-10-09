package com.licly.order.feign;

import com.licly.wms.WmsApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * 仓储系统开放接口
 *
 * @author licly
 * @date 2020/10/6
 */
@Component
@FeignClient("wms-service")
public interface WmsService extends WmsApi {

}
