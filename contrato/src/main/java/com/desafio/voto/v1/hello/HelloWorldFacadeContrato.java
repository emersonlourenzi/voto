package com.desafio.voto.v1.hello;

import com.desafio.voto.hello.HelloWorldFacadeImplementacao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class HelloWorldFacadeContrato {

    private final HelloWorldFacadeImplementacao facade;

    public String testeHelloWorld() {
        return facade.testeHelloWorld();
    }
}
