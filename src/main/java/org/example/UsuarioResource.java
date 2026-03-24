package org.example;

import lombok.NoArgsConstructor;
import org.example.DTO.UsuarioDadosCriacao;
import org.example.DTO.UsuarioDadosDetalhamento;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/usuario")
@NoArgsConstructor
public class UsuarioResource {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UsuarioDadosDetalhamento> listUsuario(){
        List<Usuario> usuarios = usuarioDAO.selectAll();
        List<UsuarioDadosDetalhamento> responseListDTO = new ArrayList<>();

        for(Usuario usuario: usuarios){
            UsuarioDadosDetalhamento dto = UsuarioMapper.toDetalhamento(usuario);
            responseListDTO.add(dto);
        }

        return responseListDTO;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criar(UsuarioDadosCriacao usuarioDadosCriacao){
        Usuario usuario = UsuarioMapper.toEntity(usuarioDadosCriacao);

        usuarioDAO.save(usuario);

        UsuarioDadosDetalhamento responseDTO = UsuarioMapper.toDetalhamento(usuario);

        return Response.status(Response.Status.CREATED)
                .entity(responseDTO)
                .build();
    }
}
