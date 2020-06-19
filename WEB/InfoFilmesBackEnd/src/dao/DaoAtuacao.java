package dao;

import bean.Atores;
import bean.Filmes;
import bean.Atuacao;
import util.ConnectionDB;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

/**
 * CREATE TABLE db2020.atuacao ( id BIGINT NOT NULL AUTO_INCREMENT, id_ator
 * BIGINT, id_filme BIGINT;
 */
public class DaoAtuacao {

    private final Connection c;

    public DaoAtuacao() throws SQLException, ClassNotFoundException {
        this.c = new ConnectionDB().getConnection();
    }

    public Atuacao inserir(Atuacao atuacao) throws SQLException {
        String sql = "INSERT INTO atuacao" + " (id_ator, id_filme)" + " values (?,?)";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1, atuacao.getA().getIdAtor());
        stmt.setInt(2, atuacao.getF().getId());
        // executa
        stmt.executeUpdate();
        ResultSet resultSet = stmt.getGeneratedKeys();
        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            atuacao.setId(id);
        }
        stmt.close();
        c.close();
        return atuacao;
    }

    public Atuacao busca(Atuacao atuacao) throws SQLException {
        String sql = "select * from atuacao WHERE id = ?";

        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, atuacao.getId());
        // executa
        ResultSet resultSet = stmt.executeQuery();
        
        

        while (resultSet.next()) {
            Atores ator = new Atores(resultSet.getInt(2));
            Filmes filme = new Filmes(resultSet.getInt(3));
            // criando o objeto Atuacao
            atuacao.setId(resultSet.getInt(1));
            atuacao.setA(ator);
            atuacao.setF(filme);

        }

        stmt.close();
        c.close();

        return atuacao;

    }

    public Atuacao altera(Atuacao atuacao) throws SQLException {
        String sql = "UPDATE atuacao SET id_ator = ?, id_filme = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, atuacao.getA().getIdAtor());
        stmt.setInt(2, atuacao.getF().getId());
        stmt.setInt(3, atuacao.getId());

        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return atuacao;
    }

    public Atuacao exclui(Atuacao atuacao) throws SQLException {
        String sql = "DELETE FROM atuacao WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, atuacao.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return atuacao;
    }

    public List<Atuacao> lista(Atuacao atuacaoEntrada) throws SQLException {
        // usus: array armazena a lista de registros

        List<Atuacao> atuacaoes = new ArrayList<>();

        String sql = "SELECT af.id, a.id, f.id, a.nome AS Ator, f.nome AS Filme "
                + "FROM atuacao AS af, atores AS a, filmes AS f "
                + "WHERE a.nome LIKE ? AND f.id = af.id_filme AND a.id = af.id_ator";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + atuacaoEntrada.getA().getNome()+"%");

        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            Atores ator = new Atores(resultSet.getInt(2), resultSet.getString(4));
            Filmes filme = new Filmes(resultSet.getInt(3), resultSet.getString(5));
            
            Atuacao atuacao = new Atuacao(
                    resultSet.getInt(1),
                    ator,
                    filme
            );

            atuacaoes.add(atuacao);
        }

        resultSet.close();
        stmt.close();
        return atuacaoes;
        

    }
}
