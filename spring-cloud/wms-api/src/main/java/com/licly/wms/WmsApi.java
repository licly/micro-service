package com.licly.wms;

import com.licly.common.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 仓储服务暴露接口
 *
 * @author licly
 * @date 2020/10/6
 */

@RequestMapping("/v1/wms")
public interface WmsApi {

    @RequestMapping("/inform/{productId}/{address}/{stockNum}")
    Result inform(@PathVariable("productId") String productId, @PathVariable("address") String address, @PathVariable("stockNum") Integer stockNum);
}
