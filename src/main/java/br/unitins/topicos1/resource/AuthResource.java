package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.AuthUsuarioDTO;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.service.HashiService;
import br.unitins.topicos1.service.TokenJwtService;
import br.unitins.topicos1.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/auth")
public class AuthResource {

    @Inject
    HashiService hashiService;

    @Inject
    UsuarioService usuarioService;

    @Inject
    TokenJwtService tokenJwtService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(AuthUsuarioDTO authUsuarioDTO){
        String hash = hashiService.getHashSenha(authUsuarioDTO.senha());

        Usuario usuario = usuarioService.findByLoginAndSenha(authUsuarioDTO.login(), hash);

        if(usuario == null){
            return Response.status(Status.NO_CONTENT).entity("Usuário não encontrado.").build();
        }
        return Response.ok().header("Autorization", tokenJwtService.generateJwt(usuario)).build();
    }
}
