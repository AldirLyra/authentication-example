package authentication.user.br.services;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import authentication.user.br.dto.AlunoDTO;
import authentication.user.br.model.Aluno;
import authentication.user.br.repository.AlunoRepository;
import authentication.user.br.repository.DisciplinaRepository;

@ApplicationScoped
public class AlunoService {

    @Inject 
    AlunoRepository alunoRepository;

    @Inject
    DisciplinaRepository disciplinaRepository;

    public List<Aluno> getAll() {
        return alunoRepository.findAllAlunos();
    }

    public List<Aluno> getListAlunos(String nome){
        return alunoRepository.findByName(nome);
    }

    public Aluno findById(Long id) {
        Aluno aluno = new Aluno();
        Optional<Aluno> alunoOptional = Aluno.findByIdOptional(id);

        if (alunoOptional.isEmpty()) {
            throw new NullPointerException("Esse aluno não foi encontrado.");
        }

        aluno = alunoOptional.get();

        return aluno;
    }

    @Transactional
    public Aluno create(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();

        aluno.setNome(alunoDTO.getNome());
        aluno.setMatricula(alunoDTO.getMatricula());
        aluno.setDisciplina(disciplinaRepository.findById(alunoDTO.getIdDisciplina()));

        aluno.persist();

        return aluno;
    }

    @Transactional
    public void update(Long id, AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();

        Optional<Aluno> alunoOptional = Aluno.findByIdOptional(id);

        if (alunoOptional.isEmpty()) {
            throw new NullPointerException("Este aluno não foi encontrado.");
        }

        aluno.setNome(alunoDTO.getNome());
        aluno.setMatricula(alunoDTO.getMatricula());
        aluno.setDisciplina(disciplinaRepository.findById(alunoDTO.getIdDisciplina()));

        aluno.persist();
    }

    @Transactional
    public void delete(Long id) {
        Optional<Aluno> alunoOptional = Aluno.findByIdOptional(id);

        if (alunoOptional.isEmpty()) {
            throw new NullPointerException("Este aluno não foi encontrado.");
        }

        Aluno aluno = alunoOptional.get();
        aluno.delete();
    }
    
}
