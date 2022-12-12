package br.authentication.user.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Bloco extends Default {

    private String nome;

    @OneToMany
    @JoinColumn(name = "id_sala")
    private List<Sala> sala;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Sala> getSala() {
        return sala;
    }
    public void setSala(List<Sala> sala) {
        this.sala = sala;
    }
    
}
