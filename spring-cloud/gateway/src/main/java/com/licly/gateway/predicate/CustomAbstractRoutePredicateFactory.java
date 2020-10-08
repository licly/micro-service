package com.licly.gateway.predicate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.web.server.ServerWebExchange;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/8
 */

@Slf4j
public class CustomAbstractRoutePredicateFactory extends AbstractRoutePredicateFactory<CustomAbstractRoutePredicateFactory.Config> {

    public CustomAbstractRoutePredicateFactory(Class configClass) {
        super(configClass);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Consumer consumer) {
        return null;
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> {
            log.info("into CustomAbstractRoutePredicateFactory" + config);
            if ("licly".equals(config.getName())) {
                return true;
            }
            return false;
        };
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
