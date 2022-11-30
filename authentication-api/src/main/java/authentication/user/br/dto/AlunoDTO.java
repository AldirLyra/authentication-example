package authentication.user.br.dto;

public class AlunoDTO {

    protected Long id;
    protected String nome;
    protected String matricula;
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
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public Long getIdDisciplina() {
        return idDisciplina;
    }
    public void setIdDisciplina(Long idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    

    
}
