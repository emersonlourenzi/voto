package com.desafio.voto.pauta;

import com.desafio.voto.pauta.model.PautaModelImplementacao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PautaFacadeImplementacao {

    private final PautaService service;

    public PautaModelImplementacao adicionar(PautaModelImplementacao model) {
        return service.adicionar(model);
    }
}
