package io.github.cHenrique0.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "cliente") /* opcional - só precisa colocar essa annotation se o nome da tabela no banco de dados for diferente do nome da classe */
public class Cliente {

    @Id /* define a primary key da tabela */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator") /* autoincrement do postgres */
    @SequenceGenerator(name = "seq_generator", sequenceName = "seq_generator", allocationSize = 1)
    @Column(name = "id")
    private int id;

    /* as outras propriedades não precisam de anotações*/
    @Column(name = "nome", length = 100) // opcional
    private String nome;

    public Cliente(){}

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
