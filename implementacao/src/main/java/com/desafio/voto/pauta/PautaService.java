package com.desafio.voto.pauta;

import com.desafio.voto.error.NotFound;
import com.desafio.voto.pauta.model.PautaModelImplementacao;
import com.desafio.voto.pauta.repository.PautaRepository;
import com.mongodb.MongoClient;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PautaService {

    private final PautaRepository repository;
    private final MongoClient mongoClient = new MongoClient();
    private final MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "bancovoto");

    public PautaModelImplementacao adicionar(PautaModelImplementacao model) {
        if (model.getMotivoPauta() == null || model.getMotivoPauta().equals("")) {
            throw new NotFound("Dados informados são inválidos");
        } else {
            model.setDataPauta(LocalDateTime.now());
            return repository.save(model);
        }
    }

}
