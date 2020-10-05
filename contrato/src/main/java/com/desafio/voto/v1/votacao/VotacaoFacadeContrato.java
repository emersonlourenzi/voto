package com.desafio.voto.v1.votacao;

import com.desafio.voto.v1.votacao.mapper.MapperVotacaoContrato;
import com.desafio.voto.v1.votacao.model.VotacaoModelContrato;
import com.desafio.voto.v1.votacao.model.VotosModelContrato;
import com.desafio.voto.votacao.VotacaoFacadeImplementacao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VotacaoFacadeContrato {

    private final VotacaoFacadeImplementacao facade;

    public VotacaoModelContrato iniciar(VotacaoModelContrato model) {
        return MapperVotacaoContrato
                .mapperVotacaoImplementacaoParaContrato(facade.iniciar(MapperVotacaoContrato
                        .mapperVotacaoContratoParaImplementacao(model)));
    }


    public VotosModelContrato votar(VotosModelContrato model) {
        return MapperVotacaoContrato
                .mapperVotosImplementacaoParaContrato(facade.votar(MapperVotacaoContrato
                        .mapperVotosContratoParaImplementacao(model)));
    }

    public String resultado(String idVotacao) {
        return facade.resultado(idVotacao);
    }
}
