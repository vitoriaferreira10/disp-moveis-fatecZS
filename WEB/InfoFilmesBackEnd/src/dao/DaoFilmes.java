/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author vfsilva
 */
import bean.Filmes;
import util.ConnectionDB;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

/**
 *
 * @author vfsilva
 */
/**
 * CREATE TABLE db2020.filmes ( 
 * id BIGINT NOT NULL AUTO_INCREMENT, 
 * nome VARCHAR(255), 
 * genero VARCHAR(255), 
 * ano BIGINT, 
 * PRIMARY KEY (id) );
 */
public class DaoFilmes {

    private final Connection c;

    public DaoFilmes() throws SQLException, ClassNotFoundException {
        this.c = new ConnectionDB().getConnection();
    }

    public Filmes busca(Filmes filme) throws SQLException {
        String sql = "SELECT * FROM filmes WHERE id = ?";

        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, filme.getId());
        // executa
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            // criando o objeto Filme
            filme.setId(resultSet.getInt(1));
            filme.setNome(resultSet.getString(2));
            filme.setGenero(resultSet.getString(3));
            filme.setAno(resultSet.getInt(4));

        }

        stmt.close();
        c.close();

        return filme;

    }

    public Filmes altera(Filmes filme) throws SQLException {
        String sql = "UPDATE filmes SET nome = ?, genero = ?, ano = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, filme.getNome());
        stmt.setString(2, filme.getGenero());
        stmt.setInt(3, filme.getAno());
        stmt.setInt(4, filme.getId());
       

        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return filme;
    }

    public Filmes exclui(Filmes filme) throws SQLException {
        String sql = "DELETE FROM filmes WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, filme.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return filme;
    }

    public Filmes inserir(Filmes filme) throws SQLException {
        String sql = "INSERT INTO filmes" + " (nome, genero, ano)" + " values (?,?,?)";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1, filme.getNome());
        stmt.setString(2, filme.getGenero());
        stmt.setInt(3, filme.getAno());

        // executa
        stmt.executeUpdate();
        ResultSet resultSet = stmt.getGeneratedKeys();
        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            filme.setId(id);
        }
        stmt.close();
        c.close();
        return filme;
    }

    public List<Filmes> lista(Filmes filmeEntrada) throws SQLException {
        // usus: array armazena a lista de registros

        List<Filmes> filmes = new ArrayList<>();

        String sql = "SELECT * FROM filmes WHERE nome LIKE ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, "%" + filmeEntrada.getNome() + "%");

        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            // criando o objeto Filmes
            Filmes filme = new Filmes(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
            // adiciona o usu à lista de filmes
            filmes.add(filme);
        }

        resultSet.close();
        stmt.close();
        return filmes;

    }
    
    public List<Filmes> listaTodos() throws SQLException{
         // usus: array armazena a lista de registros

        List<Filmes> filmeList = new ArrayList<>();
        
        String sql = "select * from filmes";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Filmes filme = new Filmes(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4));
            // adiciona o usu à lista de usus
            filmeList.add(filme);
        }
        
        rs.close();
        stmt.close();
        return filmeList;
        
    }


}
