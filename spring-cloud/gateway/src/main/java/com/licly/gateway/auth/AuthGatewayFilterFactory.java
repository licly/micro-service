package com.licly.gateway.auth;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

/**
 * 统一鉴权
 *
 * @author licly
 * @date 2020/10/8
 */
public class AuthGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthGatewayFilterFactory.Config> {


    @Override
    public GatewayFilter apply(Config config) {
        return null;
    }

    class Config {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
