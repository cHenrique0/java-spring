package io.github.cHenrique0;

import io.github.cHenrique0.domain.entity.Cliente;
import io.github.cHenrique0.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class IntroApplication {

    /* Testando operações no banco de dados */
    @Bean
    public CommandLineRunner init(@Autowired ClienteRepository repository) {
        return args -> {
            // Salva no banco
            System.out.println("\n/===== Inserindo dados =====/");
            repository.save(new Cliente("Cliente teste 1"));
            repository.save(new Cliente("Cliente teste 2"));
            repository.save(new Cliente("Outro cliente 1"));
            repository.save(new Cliente("Outro cliente 2"));

            // Lista os dados do banco
            List<Cliente> clientes = repository.findAll();
            clientes.forEach(System.out::println);

            // Atualiza os dados
            System.out.println("\n/===== Atualizando dados =====/");
            clientes.forEach(cliente -> {
                cliente.setNome(cliente.getNome() + " atualizado");
                repository.save(cliente);
            });
            clientes = repository.findAll();
            clientes.forEach(System.out::println);

            // Lista dados por nome
            System.out.println("\n/===== Buscando por dados especificos =====/");
            List<Cliente> buscaPorNome = repository.findByNomeLike("teste");
            buscaPorNome.forEach(System.out::println);

            // Deleta uma dado
            System.out.println("\n/===== Deletando todos dados =====/");
            clientes.forEach(repository::delete);

            System.out.println("\n/===== Listando os dados após as operações =====/");
            clientes = repository.findAll();
            if (clientes.isEmpty()) {
                System.out.println("> Nenhum cliente encontrado");
            }
            clientes.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(IntroApplication.class, args);
    }
}
