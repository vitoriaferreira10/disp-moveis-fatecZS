/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;

/**
 *
 * @author vfsilva
 */
public class Atores implements Serializable {

    private int id;
    private String nome;
    private int idade;
    private String sexo;
    
    public Atores()
    {}

    public Atores(int id, String nome, int idade, String sexo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;

    }

    public Atores(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Atores(int id) {
        this.id = id;
    }

    public int getIdAtor() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override

    public String toString() {
        return "Atores{"
                + "id=" + id
                + ", nome=" + nome
                + ", idade=" + idade
                + ", sexo=" + sexo
                + '}';
    }

}
