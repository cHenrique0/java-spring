package io.github.cHenrique0.domain.repository;

import io.github.cHenrique0.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository /* Classe que faz operações no banco de dados */
public class ClienteRepository {

    /* Interface jpa que faz as operações no banco de dados */
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void salvar(Cliente cliente) {
        entityManager.persist(cliente);
    }

    @Transactional
    public List<Cliente> listarTodos() {
        return entityManager
                .createQuery("from Cliente", Cliente.class)
                .getResultList();
    }

    @Transactional(readOnly = true) /* transação apenas leitura */
    public List<Cliente> buscarPorNome(String nome){

        String jpql = "select c from Cliente c where c.nome like :nome"; // os ':' definem o parametro jpa da query
        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
        query.setParameter("nome", "%"+nome+"%");

        return query.getResultList();
    }

    @Transactional
    public void atualizar(Cliente cliente) {
        entityManager.merge(cliente);
    }

    @Transactional
    public void deletar(Cliente cliente){
        if(!entityManager.contains(cliente)) {
            cliente = entityManager.merge(cliente);
        }
        entityManager.remove(cliente);
    }

    @Transactional
    public void deletar(int id){
        /* busca o cliente pelo id */
        Cliente cliente = entityManager.find(Cliente.class, id);
        deletar(cliente);
    }
}
