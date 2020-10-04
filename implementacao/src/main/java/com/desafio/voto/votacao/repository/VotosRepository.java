package com.desafio.voto.votacao.repository;

import com.desafio.voto.votacao.model.VotosModelImplementacao;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VotosRepository extends MongoRepository<VotosModelImplementacao, String> {
    Optional<VotosModelImplementacao> findById(String s);

    @Override
    <S extends VotosModelImplementacao> S save(S entity);

    @Override
    void deleteById(String s);
}
