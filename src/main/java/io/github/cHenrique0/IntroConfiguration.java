package io.github.cHenrique0;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IntroConfiguration {

    @Bean(name="applicationName")
    public String applicationName() {
        return "Introdução ao Spring Boot";
    }
}
