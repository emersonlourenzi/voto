package com.desafio.voto.hello;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HelloWorldService {

    public String testeHelloWorld() {
        return "Hello world";
    }

}
