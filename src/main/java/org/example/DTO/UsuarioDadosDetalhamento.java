package org.example.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Usuario;

@Data
@NoArgsConstructor
public class UsuarioDadosDetalhamento {

    private Long id;
    private String nome;

    public UsuarioDadosDetalhamento(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
    }

}
