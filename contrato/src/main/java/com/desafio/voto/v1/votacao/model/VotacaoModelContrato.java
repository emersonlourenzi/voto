package com.desafio.voto.v1.votacao.model;

import com.desafio.voto.enuns.VotoEnum;
import com.desafio.voto.v1.associado.model.AssociadoModelContrato;
import com.desafio.voto.v1.pauta.model.PautaModelContrato;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "votacao")
public class VotacaoModelContrato {

    @NotNull
    private PautaModelContrato pautaModelContrato;
    @NotNull
    private AssociadoModelContrato associadoModelContrato;
    @NotNull
    private VotoEnum votoEnum;

}
