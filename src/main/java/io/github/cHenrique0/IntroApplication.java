package io.github.cHenrique0;

import io.github.cHenrique0.annotations.Cachorro;
import io.github.cHenrique0.annotations.Gato;
import io.github.cHenrique0.interfaces.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class IntroApplication {

    @Value("${application.name}") // chave no arquivo 'application.properties'
    private String applicationName;

    //@Cachorro
    @Gato
    private Animal animal;

    @Bean(name="executarAnimal")
    public CommandLineRunner executar() {
        return args -> {
            this.animal.fazerBarulho();
        };
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return applicationName;
    }

    public static void main(String[] args) {
        SpringApplication.run(IntroApplication.class, args);
    }
}
