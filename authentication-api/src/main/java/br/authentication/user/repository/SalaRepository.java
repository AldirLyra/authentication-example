package br.authentication.user.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.authentication.user.model.Sala;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class SalaRepository implements PanacheRepository<Sala> {

    public List<Sala> findByName(String nome) {
        return find("nome LIKE ?1", "%" + nome + "%").list();
    }

    public List<Sala> findAllSalas() {
        return listAll();
    }
}
