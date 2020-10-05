package com.desafio.voto.votacao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "votacao")
public class VotacaoModelImplementacao {

    private String id;
    private String idPauta;
    private Long inicioVotacao;
    private Long duracaoVotacao;
    private Long fimVotacao;

}
