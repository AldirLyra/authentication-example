package authentication.user.br.dto;

public class DisciplinaDTO {
    
    protected Long id;
    protected String nome;
    protected Long idSala;
    protected Long idProfessor;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getIdSala() {
        return idSala;
    }
    public void setIdSala(Long idSala) {
        this.idSala = idSala;
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
