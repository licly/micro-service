package com.licly.order.web;

import com.licly.utils.SleepUtils;
import com.mysql.cj.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/25
 */
@RestController
@RequestMapping("/log")
@Slf4j
public class LogWeb {

    @RequestMapping("/print")
    public void log() {
        SleepUtils.sleep(1);
        log.info("info");
        log.debug("debug|");
        log.warn("warn");
        throw new RuntimeException();
    }
}
