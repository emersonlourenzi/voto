package com.desafio.voto.pauta.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "pauta")
public class PautaModelImplementacao {

    private String id;
    private String motivoPauta;
    private LocalDateTime dataPauta;

}
