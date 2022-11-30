package authentication.user.br.model;

import javax.persistence.Entity;

@Entity
public class Sala extends Default {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
