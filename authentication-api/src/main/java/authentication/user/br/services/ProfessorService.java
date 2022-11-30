package authentication.user.br.services;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import authentication.user.br.dto.ProfessorDTO;
import authentication.user.br.model.Professor;
import authentication.user.br.repository.ProfessorRepository;

@ApplicationScoped
public class ProfessorService {

    @Inject
    ProfessorRepository professorRepository;
    
    public List<Professor> getAll() {
        return professorRepository.findAllProfessores();
    }

    public List<Professor> getListProfessors(String nome){
        return professorRepository.findByName(nome);
    }

    public Professor findById(Long id) {
        Professor professor = new Professor();
        Optional<Professor> professorOptional = Professor.findByIdOptional(id);

        if (professorOptional.isEmpty()) {
            throw new NullPointerException("Esse professor não foi encontrado.");
        }

        professor = professorOptional.get();

        return professor;
    }

    @Transactional
    public Professor create(ProfessorDTO professorDTO) {
        Professor professor = new Professor();

        professor.setNome(professorDTO.getNome());
        professor.setMatricula(professorDTO.getMatricula());

        professor.persist();

        return professor;
    }

    @Transactional
    public void update(Long id, ProfessorDTO professorDTO) {
        Professor professor = new Professor();

        Optional<Professor> professorOptional = Professor.findByIdOptional(id);

        if (professorOptional.isEmpty()) {
            throw new NullPointerException("Este professor não foi encontrado.");
        }

        professor.setNome(professorDTO.getNome());
        professor.setMatricula(professorDTO.getMatricula());

        professor.persist();
    }

    @Transactional
    public void delete(Long id) {
        Optional<Professor> professorOptional = Professor.findByIdOptional(id);

        if (professorOptional.isEmpty()) {
            throw new NullPointerException("Este professor não foi encontrado.");
        }

        Professor professor = professorOptional.get();
        professor.delete();
    }
}
