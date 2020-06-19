/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import bean.Filmes;
import dao.DaoFilmes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ProfAlexandre
 */
public class ControllerFilmes {
    
    public static DaoFilmes daoFilme;

    public Filmes buscaFilmesPorId (Filmes filme) throws SQLException, ClassNotFoundException {
        daoFilme = new DaoFilmes();
        return daoFilme.busca(filme);
    }

    public Filmes inserirFilmes (Filmes filme) throws SQLException, ClassNotFoundException {
        daoFilme = new DaoFilmes();
        return daoFilme.inserir(filme);
    }

    public Filmes alteraFilmes (Filmes filme) throws SQLException, ClassNotFoundException {
        daoFilme = new DaoFilmes();
        return daoFilme.altera(filme);
    }

    public Filmes excluiFilmes (Filmes filme) throws SQLException, ClassNotFoundException {
        daoFilme = new DaoFilmes();
        return daoFilme.exclui(filme);
    }

    public List<Filmes> listaFilmes (Filmes filme) throws SQLException, ClassNotFoundException {
        List<Filmes> listAtores = new ArrayList();
        daoFilme = new DaoFilmes();
        listAtores = daoFilme.lista(filme);
        return listAtores;
    }
    
        public List<Filmes> listaTodos () throws SQLException, ClassNotFoundException {
        List<Filmes> listFilmes = new ArrayList();
        daoFilme = new DaoFilmes();
        listFilmes = daoFilme.listaTodos();
        return listFilmes;
    }
}
