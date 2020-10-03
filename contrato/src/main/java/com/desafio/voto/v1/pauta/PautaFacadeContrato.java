package com.desafio.voto.v1.pauta;

import com.desafio.voto.pauta.PautaFacadeImplementacao;
import com.desafio.voto.v1.pauta.mapper.MapperPautaContrato;
import com.desafio.voto.v1.pauta.model.PautaModelContrato;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PautaFacadeContrato {

    private final PautaFacadeImplementacao facade;

    public PautaModelContrato adicionar(PautaModelContrato model) {
        return MapperPautaContrato
                .mapperPautaImplementacaoParaContrato(facade.adicionar(MapperPautaContrato
                        .mapperPautaContratoParaImplementacao(model)));
    }
}
