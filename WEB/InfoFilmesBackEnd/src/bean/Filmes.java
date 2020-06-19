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
public class Filmes implements Serializable {

    private int id;
    private String nome;
    private String genero;
    private int ano;
    
    public Filmes()
    {}

    public Filmes(int id, String nome, String genero, int ano) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.ano = ano;

    }

    public Filmes(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Filmes(int id) {
        this.id = id;
    }

    public int getId() {
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Filmes{"
                + "id=" + id
                + ", nome=" + nome
                + ", genero=" + genero
                + ", ano=" + ano
                + '}';
    }

}
