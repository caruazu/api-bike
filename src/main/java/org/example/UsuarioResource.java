package org.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/usuarios")
public class UsuarioResource {
    private final UsuarioService usuarioService;

    public UsuarioResource(){
        this.usuarioService = new UsuarioService(new UsuarioRepository());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioResponse listUsuario(){
        return new UsuarioResponse(usuarioService.listUsuario());
    }
}
