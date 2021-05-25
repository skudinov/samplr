package com.example.demo;

import reactor.core.publisher.Mono;

public interface DemoClient {

    Mono<String> getSomeValue(String param);

}
