package com.desafio.voto.v1.votacao.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "votacao")
@ApiModel(value = "Objeto votação")
public class VotacaoModelContrato {

    @Id
    @ApiModelProperty(value = "ID votação")
    private String id;
    @NotNull
    @ApiModelProperty(value = "ID Pauta")
    private String idPauta;
    @ApiModelProperty(value = "Inicio votação")
    private Long inicioVotacao;
    @ApiModelProperty(value = "Duração da votação em minutos")
    private Long duracaoVotacao;
    @ApiModelProperty(value = "Fim votação")
    private Long fimVotacao;

}
