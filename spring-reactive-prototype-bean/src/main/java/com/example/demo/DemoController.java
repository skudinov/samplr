package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class DemoController {
    private final DemoService demoService;

    @GetMapping("test")
    public Mono<String> test() {
        return demoService.doSomething();
    }
}
