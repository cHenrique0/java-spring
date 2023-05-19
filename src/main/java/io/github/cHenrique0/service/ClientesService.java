package io.github.cHenrique0.service;

import io.github.cHenrique0.model.Cliente;
import io.github.cHenrique0.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    /* Injetando dependencias */

    // FORMA 1 - via construtor
    private final ClientesRepository repository;

    @Autowired
    public ClientesService(ClientesRepository repository) {
        this.repository = repository;
    }

    // FORMA 2 - via propriedade(variavel)
    /*@Autowired
    private final ClientesRepository repository = new ClientesRepository();*/

    // FORMA 3 - via set
    /*private ClientesRepository repository;

    @Autowired
    public void setRepository(ClientesRepository repository) {
        this.repository = repository;
    }*/

    /* Funções de exemplo */
    public void salvarCliente(Cliente cliente) {
        validarCliente(cliente);
        this.repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente) {
        // Aplica validações
    }

}
