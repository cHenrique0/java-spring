package io.github.cHenrique0.domain.repository;

import io.github.cHenrique0.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository /* Classe que faz operações no banco de dados */
public class ClienteRepository {

    /* Scripts */
    private static final String INSERT = "insert into cliente (nome) values (?)";
    private static final String SELECT_ALL = "select * from cliente";
    private static final String UPDATE = "update cliente set nome = ? where id = ?";
    private static final String DELETE = "delete from cliente where id = ?";
    private static final String SELECT_BY_NAME = "select * from cliente where nome like ?";

    /* Conexão com o banco configurado em application.properties */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void salvar(Cliente cliente) {
        jdbcTemplate.update(INSERT, cliente.getNome()); // executa scripts sql — atualização, deleção e inserção
    }

    public List<Cliente> listarTodos() {
        return jdbcTemplate.query(SELECT_ALL, getClienteRowMapper());
    }

    public List<Cliente> buscarPorNome(String nome){
        return jdbcTemplate.query(SELECT_BY_NAME, new Object[]{"%" + nome + "%"}, getClienteRowMapper());
    }

    public void atualizar(Cliente cliente) {
        jdbcTemplate.update(UPDATE, cliente.getNome(), cliente.getId());
    }

    public void deletar(Cliente cliente){
        this.deletar(cliente.getId());
    }

    public void deletar(int id){
        jdbcTemplate.update(DELETE, id);
    }

    private static RowMapper<Cliente> getClienteRowMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {

                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");

                return new Cliente(id, nome);
            }
        };
    }
}
