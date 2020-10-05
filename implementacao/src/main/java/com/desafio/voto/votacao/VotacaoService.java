package com.desafio.voto.votacao;

import com.desafio.voto.votacao.model.VotacaoModelImplementacao;
import com.desafio.voto.votacao.repository.VotacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
@AllArgsConstructor
public class VotacaoService {

    private final VotacaoRepository repository;

    public VotacaoModelImplementacao iniciar(VotacaoModelImplementacao model) {
        if (Objects.isNull(model.getDuracaoVotacao()) || model.getDuracaoVotacao() == 0) {
            model.setDuracaoVotacao(1L);
        }
        model.setInicioVotacao(new Date().getTime());
        Long fimVotacao = new Date().getTime() + (60000 * model.getDuracaoVotacao());
        model.setFimVotacao(fimVotacao);
        return repository.save(model);
    }
}
