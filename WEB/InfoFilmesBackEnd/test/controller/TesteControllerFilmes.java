/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Filmes;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vfsilva
 */
public class TesteControllerFilmes {
    
    public TesteControllerFilmes() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void inserir() throws SQLException, ClassNotFoundException {
        Filmes filme = new Filmes(0, "Alice", "Fantasia", 2010);
        ControllerFilmes contFilmes = new ControllerFilmes();
        filme = contFilmes.inserirFilmes(filme);
        assertEquals("Alice", filme.getNome());
    }

   @Test
    public void excluir() throws SQLException, ClassNotFoundException {
        Filmes filme = new Filmes(0, "Alice", "", 0);
        ControllerFilmes contFilmes = new ControllerFilmes();
        filme = contFilmes.excluiFilmes(filme);
        assertEquals(7, filme.getId());
    }

    @Test
    public void buscar() throws SQLException, ClassNotFoundException {
        Filmes filme = new Filmes(0, "Alice", "", 0);
        ControllerFilmes contFilmes = new ControllerFilmes();
        filme = contFilmes.buscaFilmesPorId(filme);
        assertEquals("Hugh Jackman", filme.getNome());
    }

    @Test
    public void alterar() throws SQLException, ClassNotFoundException {
        Filmes filme = new Filmes(0, "Alice", "", 0);
        ControllerFilmes contFilmes = new ControllerFilmes();
        filme = contFilmes.alteraFilmes(filme);
        assertEquals("Suraj Sharma", filme.getNome());
    }
}
