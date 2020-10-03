package com.desafio.voto.v1.pauta.mapper;

import com.desafio.voto.pauta.model.PautaModelImplementacao;
import com.desafio.voto.v1.pauta.model.PautaModelContrato;

public class MapperPautaContrato {

    public static PautaModelContrato mapperPautaImplementacaoParaContrato(PautaModelImplementacao model) {
        return PautaModelContrato.builder()
                .id(model.getId())
                .motivoPauta(model.getMotivoPauta())
                .dataPauta(model.getDataPauta())
                .build();
    }

    public static PautaModelImplementacao mapperPautaContratoParaImplementacao(PautaModelContrato model) {
        return PautaModelImplementacao.builder()
                .id(model.getId())
                .motivoPauta(model.getMotivoPauta())
                .dataPauta(model.getDataPauta())
                .build();
    }

}
