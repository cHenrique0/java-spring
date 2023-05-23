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

    /* Conexão com o banco configurado em application.properties */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void salvar(Cliente cliente) {
        jdbcTemplate.update(INSERT, cliente.getNome()); // executa scripts sql — atualização, deleção e inserção
    }

    public List<Cliente> listarTodos() {
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {

                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");

                return new Cliente(id, nome);
            }
        });
    }
}
