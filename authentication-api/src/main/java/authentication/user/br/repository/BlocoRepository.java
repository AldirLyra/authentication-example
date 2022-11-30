package authentication.user.br.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import authentication.user.br.model.Bloco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class BlocoRepository implements PanacheRepository<Bloco> {

    public List<Bloco> findByName(String nome) {
        return find("nome LIKE ?1", "%" + nome + "%").list();
    }

    public List<Bloco> findAllBlocos() {
        return listAll();
    }
    
}
