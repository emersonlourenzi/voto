package com.desafio.voto.v1.votacao.mapper;

import com.desafio.voto.v1.votacao.model.VotacaoModelContrato;
import com.desafio.voto.v1.votacao.model.VotosModelContrato;
import com.desafio.voto.votacao.model.VotacaoModelImplementacao;
import com.desafio.voto.votacao.model.VotosModelImplementacao;

import java.util.Optional;

public class MapperVotacaoContrato {

    public static VotacaoModelContrato mapperVotacaoImplementacaoParaContrato(VotacaoModelImplementacao model) {
        return Optional.ofNullable(model).map(mod -> VotacaoModelContrato.builder()
                .idPauta(mod.getIdPauta())
                .fimVotacao(mod.getFimVotacao())
                .id(mod.getId())
                .duracaoVotacao(mod.getDuracaoVotacao())
                .inicioVotacao(mod.getInicioVotacao())
                .build())
                .orElse(null);
    }

    public static VotacaoModelImplementacao mapperVotacaoContratoParaImplementacao(VotacaoModelContrato model) {
        return Optional.ofNullable(model).map(mod -> VotacaoModelImplementacao.builder()
                .idPauta(mod.getIdPauta())
                .duracaoVotacao(mod.getDuracaoVotacao())
                .fimVotacao(mod.getFimVotacao())
                .id(mod.getId())
                .inicioVotacao(mod.getInicioVotacao())
                .build())
                .orElse(null);
    }

    public static VotosModelContrato mapperVotosImplementacaoParaContrato(VotosModelImplementacao model) {
        return Optional.ofNullable(model).map(mod -> VotosModelContrato.builder()
                .id(mod.getId())
                .idVotacao(mod.getIdVotacao())
                .cpfAssociado(mod.getCpfAssociado())
                .voto(mod.getVoto())
                .build())
                .orElse(null);
    }

    public static VotosModelImplementacao mapperVotosContratoParaImplementacao(VotosModelContrato model) {
        return Optional.ofNullable(model).map(mod -> VotosModelImplementacao.builder()
                .id(mod.getId())
                .idVotacao(mod.getIdVotacao())
                .cpfAssociado(mod.getCpfAssociado())
                .voto(mod.getVoto())
                .build())
                .orElse(null);
    }

}
