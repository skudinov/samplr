package com.example.demo;

import com.github.benmanes.caffeine.cache.Cache;
import lombok.RequiredArgsConstructor;
import reactor.cache.CacheMono;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DemoCachedClientImpl implements DemoClient {

    private final DemoClient demoClient;
    private final Cache<String, Object> cache;

    @Override
    public Mono<String> getSomeValue(String param) {
        return CacheMono.<String, String>lookup(cache.asMap(), param)
                .onCacheMissResume(demoClient.getSomeValue(param));
    }
}
