package io.github.cHenrique0;

import io.github.cHenrique0.annotations.DevelopmentEnv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@DevelopmentEnv /* Annotation criada durante o estudo */
public class IntroConfiguration {

    @Bean
    public CommandLineRunner executar() {
        return args -> {
            System.out.println("> RODANDO A CONFIGURAÇÃO DO AMBIENTE DE DESENVOLVIMENTO");
        };
    }
}
