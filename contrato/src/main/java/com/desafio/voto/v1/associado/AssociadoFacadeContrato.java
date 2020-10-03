package com.desafio.voto.v1.associado;

import com.desafio.voto.associado.AssociadoFacadeImplementacao;
import com.desafio.voto.v1.associado.mapper.MapperAssociadoContrato;
import com.desafio.voto.v1.associado.model.AssociadoModelContrato;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AssociadoFacadeContrato {

    private final AssociadoFacadeImplementacao facade;

    public AssociadoModelContrato adicionar(AssociadoModelContrato model) {
        return MapperAssociadoContrato
                .mapperAssociadoImplementacaoParaContrato(facade.adicionar(MapperAssociadoContrato
                        .mapperAssociadoContratoParaImplementacao(model)));
    }

    public void excluirPorId(String id) {
        facade.excluirPorId(id);
    }

    public void excluirPorCPF(String cpf) {
        facade.excluirPorCPF(cpf);
    }

    public AssociadoModelContrato editarPorId(String id, AssociadoModelContrato model) {
        return MapperAssociadoContrato
                .mapperAssociadoImplementacaoParaContrato(facade.editarPorId(id, MapperAssociadoContrato
                        .mapperAssociadoContratoParaImplementacao(model)));
    }

    public AssociadoModelContrato editarPorCPF(String cpf, AssociadoModelContrato model) {
        return MapperAssociadoContrato
                .mapperAssociadoImplementacaoParaContrato(facade.editarPorCPF(cpf, MapperAssociadoContrato
                        .mapperAssociadoContratoParaImplementacao(model)));
    }

    public AssociadoModelContrato buscaAssociadoPorId(String id) {
        return MapperAssociadoContrato.mapperAssociadoImplementacaoParaContrato(facade.buscaAssociadoPorId(id));
    }

    public AssociadoModelContrato buscaAssociadoPorCPF(String cpf) {
        return MapperAssociadoContrato.mapperAssociadoImplementacaoParaContrato(facade.buscaAssociadoPorCPF(cpf));
    }

}
