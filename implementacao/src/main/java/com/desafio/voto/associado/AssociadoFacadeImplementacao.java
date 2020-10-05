package com.desafio.voto.associado;

import com.desafio.voto.associado.model.AssociadoModelImplementacao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AssociadoFacadeImplementacao {

    private final AssociadoService service;

    public AssociadoModelImplementacao adicionar(AssociadoModelImplementacao model) {
        return service.adicionar(model);
    }

    public void excluirPorId(String id) {
        service.excluirPorId(id);
    }

    public void excluirPorCPF(String cpf) {
        service.excluirPorCPF(cpf);
    }

    public AssociadoModelImplementacao editarPorId(String id, AssociadoModelImplementacao model) {
        return service.editarPorId(id, model);
    }

    public AssociadoModelImplementacao editarPorCPF(AssociadoModelImplementacao model) {
        return service.editarPorCPF(model);
    }

    public AssociadoModelImplementacao buscaAssociadoPorId(String id) {
        return service.buscaAssociadoPorId(id);
    }

    public AssociadoModelImplementacao buscaAssociadoPorCPF(String cpf) {
        return service.buscaAssociadoPorCPF(cpf);
    }

}
