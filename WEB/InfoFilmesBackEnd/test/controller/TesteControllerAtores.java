/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Atores;
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
public class TesteControllerAtores {

    public TesteControllerAtores() {
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
        Atores ator = new Atores(7, "Teste Kinnaman", 27, "Masculino");
        ControllerAtores contAtores = new ControllerAtores();
        ator = contAtores.inserirAtores(ator);
        assertEquals("Teste Kinnaman", ator.getNome());
    }

    @Test
    public void excluir() throws SQLException, ClassNotFoundException {
        Atores ator = new Atores(7, "", 0, "");
        ControllerAtores contAtores = new ControllerAtores();
        ator = contAtores.excluiAtores(ator);
        assertEquals(7, ator.getIdAtor());
    }

    @Test
    public void buscar() throws SQLException, ClassNotFoundException {
        Atores ator = new Atores(0, "Hugh Jackman", 0, "");
        ControllerAtores contAtores = new ControllerAtores();
        ator = contAtores.buscaAtoresPorId(ator);
        assertEquals("Hugh Jackman", ator.getNome());
    }

    @Test
    public void alterar() throws SQLException, ClassNotFoundException {
        Atores ator = new Atores(0, "Teste1", 29, "Feminino");
        ControllerAtores contAtores = new ControllerAtores();
        ator = contAtores.alteraAtores(ator);
        assertEquals("Suraj Sharma", ator.getNome());
    }

}
