package com.licly.wms;

import com.licly.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 仓储
 *
 * @author licly
 * @date 2020/10/5
 */

@RestController
public class WmsService implements WmsApi {

    @Override
    public Result inform(String productId, String address, int stockNum) {
        System.out.println("通知仓库发货到" + address);
        return Result.success();
    }
}
