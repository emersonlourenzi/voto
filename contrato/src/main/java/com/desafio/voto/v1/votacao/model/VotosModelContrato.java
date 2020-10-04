package com.desafio.voto.v1.votacao.model;

import com.desafio.voto.enuns.VotoEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "votos")
@ApiModel(value = "Objeto votos")
public class VotosModelContrato {

    @ApiModelProperty(value = "ID votação")
    private String idVotacao;
    @ApiModelProperty(value = "CPF associado")
    private String cpfAssociado;
    @ApiModelProperty(value = "Voto (SIM ou NAO)")
    private VotoEnum voto;


}
