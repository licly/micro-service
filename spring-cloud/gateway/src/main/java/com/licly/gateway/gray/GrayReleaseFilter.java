package com.licly.gateway.gray;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/8
 */
public class GrayReleaseFilter implements GatewayFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return null;
    }

    @Override
    public ShortcutType shortcutType() {
        return null;
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return null;
    }

    @Override
    public String shortcutFieldPrefix() {
        return null;
    }
}
