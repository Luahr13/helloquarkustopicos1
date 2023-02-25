package br.unitins.topicos1.repository;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.topicos1.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EstadoRepository implements PanacheRepository<Estado> {
    
    public Estado findByNome(String nome){
        return find("nome", nome).firstResult();
    }

}
