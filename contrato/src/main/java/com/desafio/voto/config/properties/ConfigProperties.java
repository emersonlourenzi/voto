package com.desafio.voto.config.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ConfigProperties {

    @Value("${server.servlet.context-path}")
    private String contextPath;

}
