package com.desafio.voto.v1.hello;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class HelloWorlRestController {

    private final HelloWorldFacadeContrato facade;

    @ApiOperation(value = "Create a shopping cart", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Hello world sucesso"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno ocorrido")
    })
    @GetMapping("/hello")
    public String testeHelloWorld() {
        return facade.testeHelloWorld();
    }

}
