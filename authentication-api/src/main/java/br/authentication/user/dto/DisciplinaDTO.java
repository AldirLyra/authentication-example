package br.authentication.user.dto;

public class DisciplinaDTO {
    
    protected Long id;
    protected String nome;
    protected Long idProfessor;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getIdProfessor() {
        return idProfessor;
    }
    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    
}
