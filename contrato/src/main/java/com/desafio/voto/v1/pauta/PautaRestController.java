package com.desafio.voto.v1.pauta;

import com.desafio.voto.v1.associado.model.AssociadoModelContrato;
import com.desafio.voto.v1.pauta.model.PautaModelContrato;
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
@RequestMapping("/v1/pauta")
@AllArgsConstructor
public class PautaRestController {

    private final PautaFacadeContrato facade;

    @ApiOperation(value = "Criar nova pauta", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Pauta criada com sucesso", response = AssociadoModelContrato.class),
            @ApiResponse(code = 400, message = "Motivo da pauta deve ser informado",
                    response = AssociadoModelContrato.class),
            @ApiResponse(code = 404, message = "Página não encontrada"),
            @ApiResponse(code = 500, message = "Erro interno ocorrido")
    })
    @PostMapping("/criar")
    public PautaModelContrato adicionar(@Valid @RequestBody PautaModelContrato model) {
        return facade.adicionar(model);
    }

}
