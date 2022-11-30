package authentication.user.br.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import authentication.user.br.model.Disciplina;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class DisciplinaRepository implements PanacheRepository<Disciplina>{

    public List<Disciplina> findByName(String nome) {
        return find("nome LIKE ?1", "%" + nome + "%").list();
    }

    public List<Disciplina> findAllDisciplinas() {
        return listAll();
    }
    
}
