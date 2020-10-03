package com.desafio.voto.v1.hello;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class HelloWorlRestController {

    private final HelloWorldFacadeContrato facade;

    @GetMapping("/hello")
    public String testeHelloWorld() {
        return facade.testeHelloWorld();
    }

}
