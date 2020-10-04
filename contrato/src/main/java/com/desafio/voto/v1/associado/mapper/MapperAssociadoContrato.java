package com.desafio.voto.v1.associado.mapper;

import com.desafio.voto.associado.model.AssociadoModelImplementacao;
import com.desafio.voto.v1.associado.model.AssociadoModelContrato;

import java.util.Optional;

public class MapperAssociadoContrato {

    public static AssociadoModelContrato mapperAssociadoImplementacaoParaContrato(AssociadoModelImplementacao model) {
        return Optional.ofNullable(model).map(mod -> AssociadoModelContrato.builder()
                .id(mod.getId())
                .cpf(mod.getCpf())
                .nome(mod.getNome())
                .build())
                .orElse(null);
    }

    public static AssociadoModelImplementacao mapperAssociadoContratoParaImplementacao(AssociadoModelContrato model) {
        return Optional.ofNullable(model).map(mod -> AssociadoModelImplementacao.builder()
                .id(mod.getId())
                .cpf(mod.getCpf())
                .nome(mod.getNome())
                .build())
                .orElse(null);
    }

}
