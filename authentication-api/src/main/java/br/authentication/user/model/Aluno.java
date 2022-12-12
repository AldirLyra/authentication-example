package br.authentication.user.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Aluno extends Default {
    
    private String nome;
    private String matricula;

    @OneToMany
    @JoinColumn(name = "id_disciplina")
    private List <Disciplina> disciplina;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public List<Disciplina> getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(List<Disciplina> disciplina) {
        this.disciplina = disciplina;
    }
    
}
