package authentication.user.br.services;

import javax.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import authentication.user.br.dto.DisciplinaDTO;
import authentication.user.br.model.Disciplina;
import authentication.user.br.repository.DisciplinaRepository;
import authentication.user.br.repository.ProfessorRepository;
import authentication.user.br.repository.SalaRepository;

@ApplicationScoped
public class DisciplinaService {

    @Inject
    ProfessorRepository professorRepository;

    @Inject
    SalaRepository salaRepository;

    @Inject
    DisciplinaRepository disciplinaRepository;

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
        disciplina.setProfessor(professorRepository.findById(disciplinaDTO.getIdProfessor()));
        disciplina.setSala(salaRepository.findById(disciplinaDTO.getIdSala()));

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
        disciplina.setProfessor(professorRepository.findById(disciplinaDTO.getIdProfessor()));
        disciplina.setSala(salaRepository.findById(disciplinaDTO.getIdSala()));

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
