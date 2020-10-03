package com.desafio.voto.associado;

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
public class AssociadoEntidade {

    private String id;
    private String nome;
    private String cpf;

}
