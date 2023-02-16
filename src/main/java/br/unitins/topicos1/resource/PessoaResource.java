package br.unitins.topicos1.resource;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unitins.topicos1.model.Pessoa;

@Path("/pessoas")
public class PessoaResource {

    @GET
    public List<Pessoa> getAll() {

        // seleciona todas as pessoas do banco de dados
        return Pessoa.findAll().list();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Pessoa insert(Pessoa pessoa) {

        // adiciona a pessoa no banco de dados
        pessoa.persist();

        return pessoa;
    }
    
}
