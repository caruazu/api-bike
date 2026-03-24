package org.example;

import lombok.NoArgsConstructor;
import org.example.DTO.UsuarioDadosCriacao;
import org.example.DTO.UsuarioDadosDetalhamento;
import org.example.DTO.UsuarioDadosListagem;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/usuario")
@NoArgsConstructor
public class UsuarioResource {

    private UsuarioRepository usuarioRepository = new UsuarioRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UsuarioDadosListagem> listUsuario(){
        List<Usuario> usuarios = usuarioRepository.selectAll();
        List<UsuarioDadosListagem> listaResposta = new ArrayList<>();

        for(Usuario u: usuarios){
            UsuarioDadosListagem dto = new UsuarioDadosListagem(u.getId(), u.getNome());
            listaResposta.add(dto);
        }

        return listaResposta;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criar(UsuarioDadosCriacao usuarioDadosCriacao){
        Usuario usuario = new Usuario(usuarioDadosCriacao);
        usuarioRepository.save(usuario);
        UsuarioDadosDetalhamento responseDTO = new UsuarioDadosDetalhamento(usuario);
        return Response.status(Response.Status.CREATED)
                .entity(responseDTO)
                .build();
    }
}
