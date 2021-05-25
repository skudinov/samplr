package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class DemoClientImpl implements DemoClient {

    public Mono<String> getSomeValue(String param) {
        return Mono.just("client:" + param)
                .doOnNext(value -> log.info("getting value {} for {}", value, param));
    }
}
