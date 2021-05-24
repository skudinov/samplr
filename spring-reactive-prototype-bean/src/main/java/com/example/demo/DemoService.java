package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DemoService {
    private final ObjectProvider<Mono<DemoPrototypeBean>> objectProvider;

    public Mono<String> doSomething() {
        return objectProvider.getObject("prefix")
                .map(DemoPrototypeBean::doSomethingElse);
    }
}
