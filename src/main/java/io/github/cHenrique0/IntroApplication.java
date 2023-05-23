package io.github.cHenrique0;

import io.github.cHenrique0.domain.entity.Cliente;
import io.github.cHenrique0.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IntroApplication {

    /* Testando operações no banco de dados */
    @Bean
    public CommandLineRunner init(@Autowired ClienteRepository repository) {
        return args -> {
            // Salva no banco
            /*Cliente cliente1 = new Cliente("Cliente teste 1");
            repository.salvar(cliente1);

            Cliente cliente2 = new Cliente("Cliente teste 2");
            repository.salvar(cliente2);*/

            // Lista os dados do banco
            repository.listarTodos().forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(IntroApplication.class, args);
    }
}
