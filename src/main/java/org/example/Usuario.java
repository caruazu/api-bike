package org.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.DTO.UsuarioDadosCriacao;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    public Usuario(UsuarioDadosCriacao usuarioDadosCriacao) {
        this.nome = usuarioDadosCriacao.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
