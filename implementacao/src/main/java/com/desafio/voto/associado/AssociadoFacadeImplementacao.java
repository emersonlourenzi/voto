package com.desafio.voto.associado;

import com.desafio.voto.associado.model.AssociadoModelImplementacao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public AssociadoModelImplementacao editarPorCPF(String cpf, AssociadoModelImplementacao model) {
        return service.editarPorCPF(cpf, model);
    }

    public List<AssociadoEntidade> buscaTodosAssociados() {
        return service.buscaTodosAssociados();
    }
}
