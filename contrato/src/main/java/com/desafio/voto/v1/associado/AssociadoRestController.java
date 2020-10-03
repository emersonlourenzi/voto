package com.desafio.voto.v1.associado;

import com.desafio.voto.v1.associado.model.AssociadoModelContrato;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/associado")
@AllArgsConstructor
public class AssociadoRestController {

    private final AssociadoFacadeContrato facade;

    @ApiOperation(value = "Criar novo associado", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Criado com sucesso", response = AssociadoModelContrato.class),
            @ApiResponse(code = 404, message = "Página não encontrada"),
            @ApiResponse(code = 500, message = "Erro interno ocorrido")
    })
    @PostMapping("/adicionar")
    public AssociadoModelContrato adicionar(@Valid @RequestBody AssociadoModelContrato model) {
        return facade.adicionar(model);
    }

    @ApiOperation(value = "Excluir associado pelo id")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Deletado com sucesso", response = AssociadoModelContrato.class),
            @ApiResponse(code = 404, message = "ID de usuario não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno ocorrido")
    })
    @DeleteMapping("/excluir/id/{id}")
    public void excluirPorId(@Valid @PathVariable String id) {
        facade.excluirPorId(id);
    }

    @ApiOperation(value = "Excluir associado pelo cpf")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Deletado com sucesso", response = AssociadoModelContrato.class),
            @ApiResponse(code = 404, message = "CPF de associado não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno ocorrido")
    })
    @DeleteMapping("/excluir/cpf/{cpf}")
    public void excluirPorCPF(@Valid @PathVariable String cpf) {
        facade.excluirPorCPF(cpf);
    }

    @ApiOperation(value = "Editar associado pelo id")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Alteração efetuada com sucesso", response = AssociadoModelContrato.class),
            @ApiResponse(code = 404, message = "id de associado não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno ocorrido")
    })
    @PutMapping("/editar/id/{id}")
    public AssociadoModelContrato editarPorId(@PathVariable String id,
                                              @Valid @RequestBody AssociadoModelContrato model) {
        return facade.editarPorId(id, model);
    }

    @ApiOperation(value = "Editar associado pelo cpf")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Alteração efetuado com sucesso", response = AssociadoModelContrato.class),
            @ApiResponse(code = 404, message = "CPF de associado não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno ocorrido")
    })
    @PutMapping("/editar/cpf/{cpf}")
    public AssociadoModelContrato editarPorCPF(@Valid @PathVariable String cpf,
                                               @Valid @RequestBody AssociadoModelContrato model) {
        return facade.editarPorCPF(cpf, model);
    }

    @ApiOperation(value = "Busca associado pelo id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucesso", response = AssociadoModelContrato.class),
            @ApiResponse(code = 404, message = "ID de associado não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno ocorrido")
    })
    @GetMapping("/busca/id/{id}")
    public AssociadoModelContrato buscaAssociadoPorId(@Valid @PathVariable String id) {
        return facade.buscaAssociadoPorId(id);
    }

    @ApiOperation(value = "Busca associado pelo cpf")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucesso", response = AssociadoModelContrato.class),
            @ApiResponse(code = 404, message = "CPF de associado não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno ocorrido")
    })
    @GetMapping("/busca/cpf/{cpf}")
    public AssociadoModelContrato buscaAssociadoPorCPF(@Valid @PathVariable String cpf) {
        return facade.buscaAssociadoPorCPF(cpf);
    }

}
