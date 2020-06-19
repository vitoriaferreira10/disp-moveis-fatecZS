/**
 *
 * @author vfsilva
 */
package controller;

import bean.Atores;
import bean.Filmes;
import bean.Atuacao;
import dao.DaoAtuacao;
import java.sql.SQLException;
import java.util.List;

public class ControllerAtuacao {

    public static ControllerAtores controllerAtores;
    public static ControllerFilmes controllerFilmes;
    public static DaoAtuacao daoAtuacao;

   public Atuacao buscaAtuacaoPorId(Atuacao atuacao) throws SQLException, ClassNotFoundException {

        daoAtuacao = new DaoAtuacao();
        atuacao = daoAtuacao.busca(atuacao);

        controllerAtores = new ControllerAtores();
        controllerFilmes = new ControllerFilmes();

        Atores ator = new Atores(atuacao.getA().getIdAtor(),"");
        Filmes filme = new Filmes(atuacao.getF().getId(),"");

        atuacao.setA(controllerAtores.buscaAtoresPorId(ator));
        atuacao.setF(controllerFilmes.buscaFilmesPorId(filme));

        return atuacao;
    }

    public Atuacao inserirAtuacao(Atuacao atuacao) throws SQLException, ClassNotFoundException {
        daoAtuacao = new DaoAtuacao();
        return daoAtuacao.inserir(atuacao);
    }

    public Atuacao alteraAtuacao(Atuacao atuacao) throws SQLException, ClassNotFoundException {
        daoAtuacao = new DaoAtuacao();
        return daoAtuacao.altera(atuacao);
    }

    public Atuacao excluiAtuacao(Atuacao atuacao) throws SQLException, ClassNotFoundException {
        daoAtuacao = new DaoAtuacao();
        return daoAtuacao.exclui(atuacao);
    }

    public List<Atuacao> listaAtuacao(Atuacao atuacao) throws SQLException, ClassNotFoundException {

        controllerAtores = new ControllerAtores();
        controllerFilmes = new ControllerFilmes();

        daoAtuacao = new DaoAtuacao();

        List<Atuacao> atorfilme = daoAtuacao.lista(atuacao);

        for (Atuacao listaAF : atorfilme) {
            listaAF.setA(controllerAtores.buscaAtoresPorId(listaAF.getA()));
            listaAF.setF(controllerFilmes.buscaFilmesPorId(listaAF.getF()));
        }

        return atorfilme;
    }
}
