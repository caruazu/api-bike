package org.example;

import java.util.List;

public class UsuarioResponse {

    private List<String> usuarios;

    public UsuarioResponse(List<String> usuarios) {
        this.usuarios = usuarios;
    }

    public List<String> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<String> usuarios) {
        this.usuarios = usuarios;
    }
}
