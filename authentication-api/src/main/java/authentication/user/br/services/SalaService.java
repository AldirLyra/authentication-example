package authentication.user.br.services;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import authentication.user.br.dto.SalaDTO;
import authentication.user.br.model.Sala;
import authentication.user.br.repository.SalaRepository;

@ApplicationScoped
public class SalaService {

    @Inject
    private SalaRepository salaRepository;
    
    public List<Sala> getAll() {
        return salaRepository.findAllSalas();
    }

    public List<Sala> getListSalas(String nome){
        return salaRepository.findByName(nome);
    }

    public Sala findById(Long id) {
        Sala sala = new Sala();
        Optional<Sala> salaOptional = Sala.findByIdOptional(id);

        if (salaOptional.isEmpty()) {
            throw new NullPointerException("Esta sala não foi encontrada.");
        }

        sala = salaOptional.get();

        return sala;
    }

    @Transactional
    public Sala create(SalaDTO salaDTO) {
        Sala sala = new Sala();

        sala.setNome(salaDTO.getNome());

        sala.persist();

        return sala;
    }

    @Transactional
    public void update(Long id, SalaDTO salaDTO) {
        Sala sala = new Sala();

        Optional<Sala> salaOptional = Sala.findByIdOptional(id);

        if (salaOptional.isEmpty()) {
            throw new NullPointerException("Esta sala não foi encontrada.");
        }

        sala.setNome(salaDTO.getNome());

        sala.persist();
    }

    @Transactional
    public void delete(Long id) {
        Optional<Sala> salaOptional = Sala.findByIdOptional(id);

        if (salaOptional.isEmpty()) {
            throw new NullPointerException("Esta sala não foi encontrada.");
        }

        Sala sala = salaOptional.get();
        sala.delete();
    }

}
