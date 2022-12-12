package br.authentication.user.services;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.authentication.user.dto.SalaDTO;
import br.authentication.user.model.Sala;
import br.authentication.user.repository.DisciplinaRepository;
import br.authentication.user.repository.SalaRepository;

@ApplicationScoped
public class SalaService {

    @Inject
    private SalaRepository salaRepository;

    @Inject
    DisciplinaRepository disciplinaRepository;
    
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
        sala.setDisciplina(null);

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
        sala.setDisciplina(null);

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
