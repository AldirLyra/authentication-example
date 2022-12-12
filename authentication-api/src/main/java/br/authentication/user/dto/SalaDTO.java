package br.authentication.user.dto;

public class SalaDTO {
    
    protected Long id;
    protected String nome;
    protected Long idDisciplina;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Long getIdDisciplina() {
        return idDisciplina;
    }
    public void setIdDisciplina(Long idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    
}
