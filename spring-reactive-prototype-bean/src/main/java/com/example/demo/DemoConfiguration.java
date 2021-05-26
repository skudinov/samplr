package com.example.demo;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

@Configuration
public class DemoConfiguration {
    @Autowired
    private DemoClient demoClient;

    @Bean
    public DemoClient demoClient(Cache<String, Object> someValueCache) {
        return new DemoCachedClientImpl(new DemoClientImpl(), someValueCache);
    }

    @Bean
    public Cache<String, Object> caffeineCache() {
        return Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build();
    }

    @Bean
    @Scope("prototype")
    public Mono<DemoPrototypeBean> demoPrototypeBean(String param) {
        return Mono.zip(
                demoClient.getSomeValue(param+":1"),
                demoClient.getSomeValue(param+":2")
                    .filter(s -> true)
                    .switchIfEmpty(Mono.error(new RuntimeException("Failed getting second value")))
            )
            .map(r -> new DemoPrototypeBean(r.getT1(), r.getT2()));
    }

}
