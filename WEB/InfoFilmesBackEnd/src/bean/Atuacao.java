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
public class Atuacao implements Serializable {

    private int id;
    private Atores ato;
    private Filmes fil;

// Construtor
    
    public Atuacao(int id, Atores ator, Filmes filme) {
        this.id = id;
        this.ato = ator;
        this.fil = filme;

    }

//Gets e Sets
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public int getIdAtor() {
        if (getA() == null) {
            return 0;
        }
        return getA().getIdAtor();
    }

    public void setIdAtor(int idAtor) {
        if (this.ato == null) {
            this.ato = new Atores();
        }
        this.ato.setId(idAtor);
    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }*/

    public Atores getA() {
        return ato;
    }

    public void setA(Atores a) {
        this.ato = a;
    }

    public Filmes getF() {
        return fil;
    }

    public void setF(Filmes f) {
        this.fil = f;
    }

// Metodo toString
    
    @Override
    public String toString() {
        return "Atuacao{"
                + "id=" + id
                + ", idAtor=" + ato.getIdAtor()
                + ", idFilme=" + fil.getId()
                + ", a=" + ato.getNome()
                + ", f=" + fil.getNome()
                + '}';
    }
}
