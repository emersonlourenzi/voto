package com.desafio.voto.v1.votacao;

import com.desafio.voto.v1.associado.model.AssociadoModelContrato;
import com.desafio.voto.v1.votacao.model.VotacaoModelContrato;
import com.desafio.voto.v1.votacao.model.VotosModelContrato;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/votacao")
@AllArgsConstructor
public class VotacaoRestController {

    private final VotacaoFacadeContrato facade;

    @ApiOperation(value = "Iniciar nova votação", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Votação iniciada com sucesso", response = AssociadoModelContrato.class),
            @ApiResponse(code = 404, message = "Página não encontrada"),
            @ApiResponse(code = 500, message = "Erro interno ocorrido")
    })
    @PostMapping("/iniciar")
    public VotacaoModelContrato iniciar(@Valid @RequestBody VotacaoModelContrato model) {
        return facade.iniciar(model);
    }

    @ApiOperation(value = "Iniciar nova votação", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Votação iniciada com sucesso", response = AssociadoModelContrato.class),
            @ApiResponse(code = 404, message = "Página não encontrada"),
            @ApiResponse(code = 500, message = "Erro interno ocorrido")
    })
    @PostMapping("/votar")
    public VotosModelContrato votar(@Valid @RequestBody VotosModelContrato model) {
        return facade.votar(model);
    }

}
