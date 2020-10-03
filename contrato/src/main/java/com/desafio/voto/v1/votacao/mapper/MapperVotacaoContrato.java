package com.desafio.voto.v1.votacao.mapper;

import com.desafio.voto.v1.associado.mapper.MapperAssociadoContrato;
import com.desafio.voto.v1.pauta.mapper.MapperPautaContrato;
import com.desafio.voto.v1.votacao.model.VotacaoModelContrato;
import com.desafio.voto.votacao.model.VotacaoModelImplementacao;

public class MapperVotacaoContrato {

    public static VotacaoModelContrato mapperVotacaoImplementacaoParaContrato(VotacaoModelImplementacao model) {
        return VotacaoModelContrato.builder()
                .associadoModelContrato(MapperAssociadoContrato
                        .mapperAssociadoImplementacaoParaContrato(model.getAssociadoModelImplementacao()))
                .pautaModelContrato(MapperPautaContrato
                        .mapperPautaImplementacaoParaContrato(model.getPautaModelImplementacao()))
                .votoEnum(model.getVotoEnum())
                .build();
    }

    public static VotacaoModelImplementacao mapperVotacaoContratoParaImplementacao(VotacaoModelContrato model) {
        return VotacaoModelImplementacao.builder()
                .associadoModelImplementacao(MapperAssociadoContrato
                        .mapperAssociadoContratoParaImplementacao(model.getAssociadoModelContrato()))
                .pautaModelImplementacao(MapperPautaContrato
                        .mapperPautaContratoParaImplementacao(model.getPautaModelContrato()))
                .votoEnum(model.getVotoEnum())
                .build();
    }

}
