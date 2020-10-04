package com.desafio.voto.votacao;

import com.desafio.voto.votacao.model.VotacaoModelImplementacao;
import com.desafio.voto.votacao.model.VotosModelImplementacao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VotacaoFacadeImplementacao {

    private final VotacaoService service;
    private final VotosService votosService;

    public VotacaoModelImplementacao iniciar(VotacaoModelImplementacao model) {
        return service.iniciar(model);
    }

    public VotosModelImplementacao votar(VotosModelImplementacao model) {
        return votosService.votar(model);
    }
}
