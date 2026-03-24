package org.example;

import lombok.NoArgsConstructor;
import org.example.DTO.UsuarioDadosCriacao;
import org.example.DTO.UsuarioDadosDetalhamento;

@NoArgsConstructor
public final class UsuarioMapper {

    public static Usuario toEntity(UsuarioDadosCriacao dto) {
        return new Usuario(dto.getNome());
    }


    public static UsuarioDadosDetalhamento toDetalhamento(Usuario usuario) {
        return new UsuarioDadosDetalhamento(
                usuario.getId(),
                usuario.getNome());
    }
}
