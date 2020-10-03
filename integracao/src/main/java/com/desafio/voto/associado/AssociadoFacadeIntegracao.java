package com.desafio.voto.associado;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AssociadoFacadeIntegracao {

    private final AssociadoIntegracao integracao;

    public String verificarCPF(String cpf) {
        return integracao.verificaCPF(cpf);
    }

}
