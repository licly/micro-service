package com.reactive;

import org.junit.Test;
import reactor.core.publisher.Mono;

/**
 * Reactive
 * @author licly
 * @date 2020/10/9
 */
public class ReactiveTest {

	@Test
	public void TestMono() {
		Mono<Integer> just = Mono.just(1);
		just.subscribe(System.out::print);
	}
}
