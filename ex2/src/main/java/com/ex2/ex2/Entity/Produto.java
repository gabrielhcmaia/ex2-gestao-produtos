package com.ex2.ex2.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {
    @Id @GeneratedValue
    protected Long id;
    @Column(name="nome_produto")
    protected String nome;
    @Column(name ="preco_produto")
    protected BigDecimal preco;
    protected Integer qtdEstoque;

    public Produto(Long id, String nome, BigDecimal preco, Integer qtdEstoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", qtdEstoque=" + qtdEstoque +
                '}';
    }
}
