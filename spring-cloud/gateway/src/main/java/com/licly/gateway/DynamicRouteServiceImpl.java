package com.licly.gateway;

import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * 动态路由
 *
 * @author licly
 * @date 2020/10/8
 */

@Component
public class DynamicRouteServiceImpl implements ApplicationEventPublisherAware {

	@Resource
	private RouteDefinitionWriter routeDefinitionWriter;

	private ApplicationEventPublisher applicationEventPublisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	@Scheduled
	public void refreshRoutes() {

	}

	public Mono<ResponseEntity<Object>> delete(String id) {
		return routeDefinitionWriter
				.delete(Mono.just(id))
				.then(Mono.defer(() -> Mono.just(ResponseEntity.ok().build())));
	}

}
