package com.desafio.voto.votacao.model;

import com.desafio.voto.enuns.VotoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "votos")
public class VotosModelImplementacao {

    @Id
    private String id;
    private String idVotacao;
    private String cpfAssociado;
    private VotoEnum voto;

}
