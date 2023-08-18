package io.github.cHenrique0.domain.repository;

import io.github.cHenrique0.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/* Usando o JPA Repository */
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeLike(String name);
}
