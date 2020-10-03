package com.desafio.voto.votacao.model;

import com.desafio.voto.associado.model.AssociadoModelImplementacao;
import com.desafio.voto.enuns.VotoEnum;
import com.desafio.voto.pauta.model.PautaModelImplementacao;
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

    private PautaModelImplementacao pautaModelImplementacao;
    private AssociadoModelImplementacao associadoModelImplementacao;
    private VotoEnum votoEnum;

}
