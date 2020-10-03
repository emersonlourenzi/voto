package com.desafio.voto.associado;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class AssociadoIntegracao {

    public String verificaCPF(String cpf) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://user-info.herokuapp.com/users/".concat(cpf);
        if (restTemplate.getForEntity(url, String.class).getStatusCode().equals(HttpStatus.NOT_FOUND)) {
            return "UNABLE_TO_VOTE";
        } else {
            return restTemplate.getForEntity(url, String.class).getBody();
        }
    }

}
