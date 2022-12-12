package br.authentication.user.services;

import javax.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.authentication.user.dto.DisciplinaDTO;
import br.authentication.user.model.Disciplina;
import br.authentication.user.repository.DisciplinaRepository;
import br.authentication.user.repository.ProfessorRepository;

@ApplicationScoped
public class DisciplinaService {

    @Inject
    ProfessorRepository professorRepository;

    @Inject
    private DisciplinaRepository disciplinaRepository;

    public List<Disciplina> getAll() {
        return disciplinaRepository.findAllDisciplinas();
    }

    public List<Disciplina> getListDisciplinas(String nome){
        return disciplinaRepository.findByName(nome);
    }

    public Disciplina findById(Long id) {
        Disciplina disciplina = new Disciplina();
        Optional<Disciplina> disciplinaOptional = Disciplina.findByIdOptional(id);

        if (disciplinaOptional.isEmpty()) {
            throw new NullPointerException("Esta disciplina não foi encontrada.");
        }

        disciplina = disciplinaOptional.get();

        return disciplina;
    }

    @Transactional
    public Disciplina create(DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = new Disciplina();

        disciplina.setNome(disciplinaDTO.getNome());
        disciplina.setProfessor(null);

        disciplina.persist();

        return disciplina;
    }

    @Transactional
    public void update(Long id, DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = new Disciplina();

        Optional<Disciplina> disciplinaOptional = Disciplina.findByIdOptional(id);

        if (disciplinaOptional.isEmpty()) {
            throw new NullPointerException("Esta disciplina não foi encontrada.");
        }

        disciplina.setNome(disciplinaDTO.getNome());
        disciplina.setProfessor(null);

        disciplina.persist();
    }

    @Transactional
    public void delete(Long id) {
        Optional<Disciplina> disciplinaOptional = Disciplina.findByIdOptional(id);

        if (disciplinaOptional.isEmpty()) {
            throw new NullPointerException("Esta disciplina não foi encontrada.");
        }

        Disciplina disciplina = disciplinaOptional.get();
        disciplina.delete();
    }
    
}
