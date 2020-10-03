package com.desafio.voto.v1.associado.mapper;

import com.desafio.voto.associado.model.AssociadoModelImplementacao;
import com.desafio.voto.v1.associado.model.AssociadoModelContrato;

public class MapperAssociadoContrato {

    public static AssociadoModelContrato mapperAssociadoImplementacaoParaContrato(AssociadoModelImplementacao model) {
        return AssociadoModelContrato.builder()
                .cpf(model.getCpf())
                .id(model.getId())
                .nome(model.getNome())
                .build();
    }

    public static AssociadoModelImplementacao mapperAssociadoContratoParaImplementacao(AssociadoModelContrato model) {
        return AssociadoModelImplementacao.builder()
                .cpf(model.getCpf())
                .id(model.getId())
                .nome(model.getNome())
                .build();
    }

}
