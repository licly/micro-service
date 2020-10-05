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
@RequestMapping("/v1/wms")
public class WmsWeb {

    @PostMapping("/inform")
    public Result inform() {
        return Result.success();
    }
}
