package com.desafio.voto.votacao;

import com.desafio.voto.votacao.model.VotacaoModelImplementacao;
import com.desafio.voto.votacao.repository.VotacaoRepository;
import com.mongodb.MongoClient;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class VotacaoService {

    private final VotacaoRepository repository;
    private final MongoClient mongoClient = new MongoClient();
    private final MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "bancovotacao");

    public VotacaoModelImplementacao iniciar(VotacaoModelImplementacao model) {
        if(model.getDuracaoVotacao() == 0 || model.getDuracaoVotacao() == null){
            model.setDuracaoVotacao(1);
        }
        model.setInicioVotacao(new Date().getTime());
        Long fimVotacao = new Date().getTime() + (60000*model.getDuracaoVotacao());
        model.setFimVotacao(fimVotacao);
        return repository.save(model);
    }
}
