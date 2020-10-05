package com.desafio.voto.v1.pauta.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "pauta")
@ApiModel(value = "Objeto Pauta")
public class PautaModelContrato {

    @Id
    @ApiModelProperty(value = "ID da pauta")
    private String id;
    @ApiModelProperty(value = "Motivo da pauta")
    @NotNull(message = "Motivo da pauta deve ser informado")
    private String motivoPauta;
    @ApiModelProperty(value = "Data da pauta")
    private LocalDateTime dataPauta;

}


