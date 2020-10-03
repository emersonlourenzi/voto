package com.desafio.voto.v1.associado.model;

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
public class AssociadoModelContrato {

    private String id;
    private String nome;
    private String cpf;

}
