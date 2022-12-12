package br.authentication.user.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.authentication.user.model.Professor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProfessorRepository implements PanacheRepository<Professor>{

    public List<Professor> findByName(String nome) {
        return find("nome LIKE ?1", "%" + nome + "%").list();
    }

    public List<Professor> findAllProfessores() {
        return listAll();
    }
    
}
