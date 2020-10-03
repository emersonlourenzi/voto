package com.desafio.voto.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VotoEnum {
    SIM("Voto sim"),
    NAO("Voto não");

    private final String descricao;
}
