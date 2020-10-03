package com.desafio.voto.votacao.repository;

import com.desafio.voto.votacao.model.VotacaoModelImplementacao;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VotacaoRepository extends MongoRepository<VotacaoModelImplementacao, String> {

    Optional<VotacaoModelImplementacao> findById(String s);

    @Override
    <S extends VotacaoModelImplementacao> S save(S entity);

    @Override
    void deleteById(String s);

}
