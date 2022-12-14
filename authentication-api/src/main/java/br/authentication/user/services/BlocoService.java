package br.authentication.user.services;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.authentication.user.dto.BlocoDTO;
import br.authentication.user.model.Bloco;
import br.authentication.user.repository.BlocoRepository;
import br.authentication.user.repository.SalaRepository;

@ApplicationScoped
public class BlocoService {

    @Inject
    private BlocoRepository blocoRepository;

    @Inject
    SalaRepository salaRepository;

    public List<Bloco> getAll() {
        return blocoRepository.findAllBlocos();
    }

    public List<Bloco> getListBlocos(String nome){
        return blocoRepository.findByName(nome);
    }

    public Bloco findById(Long id) {
        Bloco bloco = new Bloco();
        Optional<Bloco> blocoOptional = Bloco.findByIdOptional(id);

        if (blocoOptional.isEmpty()) {
            throw new NullPointerException("Esse bloco não foi encontrado.");
        }

        bloco = blocoOptional.get();

        return bloco;
    }

    @Transactional
    public Bloco create(BlocoDTO blocoDTO) {
        Bloco bloco = new Bloco();

        bloco.setNome(blocoDTO.getNome());
        bloco.setSala(null);

        bloco.persist();

        return bloco;
    }

    @Transactional
    public void update(Long id, BlocoDTO blocoDTO) {
        Bloco bloco = new Bloco();

        Optional<Bloco> blocoOptional = Bloco.findByIdOptional(id);

        if (blocoOptional.isEmpty()) {
            throw new NullPointerException("Este bloco não foi encontrado.");
        }

        bloco.setNome(blocoDTO.getNome());
        bloco.setSala(null);
        bloco.persist();
    }

    @Transactional
    public void delete(Long id) {
        Optional<Bloco> blocoOptional = Bloco.findByIdOptional(id);

        if (blocoOptional.isEmpty()) {
            throw new NullPointerException("Este bloco não foi encontrado.");
        }

        Bloco bloco = blocoOptional.get();
        bloco.delete();
    }
    
}
