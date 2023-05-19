package io.github.cHenrique0;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development") /* Faz a configuração ficar disponivel apenas no ambiente passado por parametro*/
public class IntroConfiguration {

    @Bean
    public CommandLineRunner executar() {
        return args -> {
            System.out.println("> RODANDO A CONFIGURAÇÃO DO AMBIENTE DE DESENVOLVIMENTO");
        };
    }
}
