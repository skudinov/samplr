package com.example.demo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DemoPrototypeBean {
    private final String param1;
    private final String param2;

    public String doSomethingElse() {
        return param1+","+param2;
    }
}
