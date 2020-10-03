package com.desafio.voto.associado.repository;

import com.desafio.voto.associado.model.AssociadoModelImplementacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssociadoRepository extends MongoRepository<AssociadoModelImplementacao, String> {

    Optional<AssociadoModelImplementacao> findById(String s);

    @Override
    <S extends AssociadoModelImplementacao> S save(S entity);

    @Override
    void deleteById(String s);

}
