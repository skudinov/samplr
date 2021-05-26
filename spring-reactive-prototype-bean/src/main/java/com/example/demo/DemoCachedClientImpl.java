package com.example.demo;

import com.github.benmanes.caffeine.cache.Cache;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DemoCachedClientImpl implements DemoClient {

    private final DemoClient demoClient;
    private final Cache<String, String> cache;

    @Override
    public Mono<String> getSomeValue(String param) {
        return Mono.justOrEmpty(cache.getIfPresent(param))
                .switchIfEmpty(demoClient
                        .getSomeValue(param)
                        .doOnNext(value -> cache.put(param, value)));
    }
}
