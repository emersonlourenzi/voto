package com.desafio.voto.v1.votacao.model;

import com.desafio.voto.enuns.VotoEnum;
import com.desafio.voto.v1.associado.model.AssociadoModelContrato;
import com.desafio.voto.v1.pauta.model.PautaModelContrato;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "Objeto votação")
public class VotacaoModelContrato {

    @NotNull
    @ApiModelProperty(value = "Pauta a ser votada")
    private PautaModelContrato pautaModelContrato;
    @NotNull
    @ApiModelProperty(value = "Associado a votar")
    private AssociadoModelContrato associadoModelContrato;
    @NotNull
    @ApiModelProperty(value = "Voto SIM ou NÃo")
    private VotoEnum votoEnum;

}
