package br.authentication.user.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.authentication.user.model.Aluno;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class AlunoRepository implements PanacheRepository<Aluno> {

    public List<Aluno> findByName(String nome) {
        return find("nome LIKE ?1", "%" + nome + "%").list();
    }

    public List<Aluno> findAllAlunos() {
        return listAll();
    }
}
