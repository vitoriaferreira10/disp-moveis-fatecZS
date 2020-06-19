package dao;

import bean.Atores;
import util.ConnectionDB;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

/**
 * CREATE TABLE db2020.atores ( 
 * id BIGINT NOT NULL AUTO_INCREMENT, 
 * nome VARCHAR(255), 
 * idade BIGINT, 
 * sexo VARCHAR(255), 
 * PRIMARY KEY (id) );
 */
public class DaoAtores {

    private final Connection c;

    public DaoAtores() throws SQLException, ClassNotFoundException {
        this.c = new ConnectionDB().getConnection();
    }

    public Atores busca(Atores ator) throws SQLException {
        String sql = "select * from atores WHERE id = ?";

        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, ator.getIdAtor());
        // executa
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            // criando o objeto Ator
            ator.setId(resultSet.getInt(1));
            ator.setNome(resultSet.getString(2));
            ator.setIdade(resultSet.getInt(3));
            ator.setSexo(resultSet.getString(4));

        }

        stmt.close();
        c.close();

        return ator;

    }

    public Atores altera(Atores ator) throws SQLException {
        String sql = "UPDATE atores SET nome = ?, idade = ?, sexo = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, ator.getNome());
        stmt.setInt(2, ator.getIdade());
        stmt.setString(3, ator.getSexo());
        stmt.setInt(4, ator.getIdAtor());

        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return ator;
    }

    public Atores exclui(Atores ator) throws SQLException {
        String sql = "DELETE FROM atores WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, ator.getIdAtor());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return ator;
    }

    public Atores inserir(Atores ator) throws SQLException {
        String sql = "INSERT INTO atores" + " (nome, idade, sexo)" + " values (?,?,?)";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1, ator.getNome());
        stmt.setInt(2, ator.getIdade());
        stmt.setString(3, ator.getSexo());

        // executa
        stmt.executeUpdate();
        ResultSet resultSet = stmt.getGeneratedKeys();
        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            ator.setId(id);
        }
        stmt.close();
        c.close();
        return ator;
    }

    public List<Atores> lista(Atores atorEntrada) throws SQLException {
        // usus: array armazena a lista de registros

        List<Atores> atores = new ArrayList<>();

        String sql = "SELECT * FROM atores WHERE nome LIKE ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, "%" + atorEntrada.getNome() + "%");

        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            // criando o objeto Logradouro
            Atores ator = new Atores(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4));
            // adiciona o usu à lista de logs
            atores.add(ator);
        }

        resultSet.close();
        stmt.close();
        return atores;

    }
    
    public List<Atores> listaTodos() throws SQLException{
         // usus: array armazena a lista de registros

        List<Atores> atorList = new ArrayList<>();
        
        String sql = "select * from atores";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Atores ator = new Atores(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4));
            // adiciona o usu à lista de usus
            atorList.add(ator);
        }
        
        rs.close();
        stmt.close();
        return atorList;
        
    }

}
