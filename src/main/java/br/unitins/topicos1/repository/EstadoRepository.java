package br.unitins.topicos1.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.topicos1.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EstadoRepository implements PanacheRepository<Estado> {
    
    public Estado findByNome(String nome){
        return find("nome", nome).firstResult();
    }

    public List<Estado> findByNomeList(String nome){
        return find("UPPER(nome) LIKE ?1", nome).list();
    }

}
