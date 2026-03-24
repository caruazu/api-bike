package org.example.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class UsuarioDadosCriacao {
    String nome;

    @JsonCreator
    public UsuarioDadosCriacao(
            @JsonProperty("nome") String nome
    ) {
        this.nome = nome;
    }
}
