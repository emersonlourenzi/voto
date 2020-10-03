package com.desafio.voto.hello;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class HelloWorldFacadeImplementacao {

    private final HelloWorldService service;

    public String testeHelloWorld() {
        return service.testeHelloWorld();
    }

}
