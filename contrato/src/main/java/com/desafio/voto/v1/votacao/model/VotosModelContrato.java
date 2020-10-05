package com.desafio.voto.v1.votacao.model;

import com.desafio.voto.enuns.VotoEnum;
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
@Document(value = "votos")
@ApiModel(value = "Objeto votos")
public class VotosModelContrato {

    @Id
    @ApiModelProperty(value = "ID votos")
    private String id;
    @NotNull
    @ApiModelProperty(value = "ID votação")
    private String idVotacao;
    @NotNull
    @ApiModelProperty(value = "CPF associado")
    private String cpfAssociado;
    @NotNull
    @ApiModelProperty(value = "Voto (SIM ou NAO)")
    private VotoEnum voto;


}
