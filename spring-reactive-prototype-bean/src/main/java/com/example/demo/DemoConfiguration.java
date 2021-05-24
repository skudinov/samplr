package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import reactor.core.publisher.Mono;

@Configuration
public class DemoConfiguration {
    @Bean
    @Scope("prototype")
    public Mono<DemoPrototypeBean> demoPrototypeBean(String prefix) {
        return Mono.zip(
                Mono.just(prefix+":1"),
                Mono.just(prefix+":2")
                    .filter(s -> false)
                    .switchIfEmpty(Mono.error(new RuntimeException("Failed getting second value")))
            )
            .map(r -> new DemoPrototypeBean(r.getT1(), r.getT2()));
    }
}
