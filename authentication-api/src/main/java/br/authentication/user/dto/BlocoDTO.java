package br.authentication.user.dto;

public class BlocoDTO {

    protected Long id;
    protected String nome;
    protected Long idSala;

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
    public Long getIdSala() {
        return idSala;
    }
    public void setIdSala(Long idSala) {
        this.idSala = idSala;
    }

}
