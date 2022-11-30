package authentication.user.br.model;

import javax.persistence.Entity;

@Entity
public class Professor extends Default {

    private String nome;
    private String matricula;

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

    

}
