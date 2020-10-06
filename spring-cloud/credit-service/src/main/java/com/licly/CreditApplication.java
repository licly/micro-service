package com.licly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 积分服务
 *
 * @author licly
 * @date 2020/10/6
 */

@SpringBootApplication
@EnableEurekaClient
public class CreditApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditApplication.class, args);
    }
}
