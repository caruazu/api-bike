package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public String listUsuario(){
        List<Usuario> usuarios = usuarioRepository.selectAll();

        return usuarios.stream().map(Usuario::getNome).collect(Collectors.joining(" "));
    }
}
