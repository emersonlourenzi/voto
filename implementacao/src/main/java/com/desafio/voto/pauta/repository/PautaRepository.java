package com.desafio.voto.pauta.repository;

import com.desafio.voto.pauta.model.PautaModelImplementacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PautaRepository extends MongoRepository<PautaModelImplementacao, String> {

    Optional<PautaModelImplementacao> findById(String s);

    @Override
    <S extends PautaModelImplementacao> S save(S entity);

    @Override
    void deleteById(String s);

}
