package com.licly.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 睡眠工具
 *
 * @author licly
 * @date 2020/10/9
 */

@Slf4j
public class SleepUtils {

    public static void sleep(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            log.warn("睡眠中断");
        }
    }
}
