/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import bean.Atores;
import dao.DaoAtores;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ProfAlexandre
 */
public class ControllerAtores {
    
    public static DaoAtores daoAtor;

    public Atores buscaAtoresPorId (Atores ator) throws SQLException, ClassNotFoundException {
        daoAtor = new DaoAtores();
        return daoAtor.busca(ator);
    }

    public Atores inserirAtores (Atores ator) throws SQLException, ClassNotFoundException {
        daoAtor = new DaoAtores();
        return daoAtor.inserir(ator);
    }

    public Atores alteraAtores (Atores ator) throws SQLException, ClassNotFoundException {
        daoAtor = new DaoAtores();
        return daoAtor.altera(ator);
    }

    public Atores excluiAtores (Atores ator) throws SQLException, ClassNotFoundException {
        daoAtor = new DaoAtores();
        return daoAtor.exclui(ator);
    }

    public List<Atores> listaAtores (Atores ator) throws SQLException, ClassNotFoundException {
        List<Atores> listAtores = new ArrayList();
        daoAtor = new DaoAtores();
        listAtores = daoAtor.lista(ator);
        return listAtores;
    }
    public List<Atores> listaTodos () throws SQLException, ClassNotFoundException {
        List<Atores> listAtores = new ArrayList();
        daoAtor = new DaoAtores();
        listAtores = daoAtor.listaTodos();
        return listAtores;
    }
    
}
