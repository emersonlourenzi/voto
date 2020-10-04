package com.desafio.voto.v1.votacao.model;

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
    private String idPauta;
    @ApiModelProperty(value = "Duração da votação em minutos")
    private Integer duracaoVotacao;

}
