package com.desafio.voto.v1.pauta.mapper;

import com.desafio.voto.pauta.model.PautaModelImplementacao;
import com.desafio.voto.v1.pauta.model.PautaModelContrato;

import java.util.Optional;

public class MapperPautaContrato {

    public static PautaModelContrato mapperPautaImplementacaoParaContrato(PautaModelImplementacao model) {
        return Optional.ofNullable(model).map(mod -> PautaModelContrato.builder()
                .id(mod.getId())
                .dataPauta(mod.getDataPauta())
                .motivoPauta(mod.getMotivoPauta())
                .build())
                .orElse(null);
    }

    public static PautaModelImplementacao mapperPautaContratoParaImplementacao(PautaModelContrato model) {
        return Optional.ofNullable(model).map(mod -> PautaModelImplementacao.builder()
                .id(mod.getId())
                .dataPauta(mod.getDataPauta())
                .motivoPauta(mod.getMotivoPauta())
                .build())
                .orElse(null);
    }

}
