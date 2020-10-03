package com.desafio.voto.v1.associado.model;

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
@Document(value = "associado")
@ApiModel(value = "Objeto associado")
public class AssociadoModelContrato {

    @ApiModelProperty(value = "ID do ssociado")
    private String id;
    @ApiModelProperty(value = "Nome do associado")
    private String nome;
    @ApiModelProperty(value = "CPF do associado")
    private String cpf;

}
