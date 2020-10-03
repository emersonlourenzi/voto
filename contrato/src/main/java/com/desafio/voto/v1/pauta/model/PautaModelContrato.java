package com.desafio.voto.v1.pauta.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "pauta")
public class PautaModelContrato {

    private String id;
    @NotNull(message = "Motivo pauta deve ser informado")
    private String motivoPauta;
    private Date dataPauta;

}


