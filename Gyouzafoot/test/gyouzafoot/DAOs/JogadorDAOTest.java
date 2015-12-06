/*
 * Copyright (C) 2015 hydrocat
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package gyouzafoot.DAOs;

import gyouzafoot.Objetos.Jogador;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hydrocat
 */
public class JogadorDAOTest {
    
    public JogadorDAOTest() {
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

    /**
     * Test of inserir method, of class JogadorDAO.
     */
    @Test
    public void testInserir() throws Exception {
    System.out.println("inserir");
    Jogador jogador = new Jogador("Vitorio", 19);
    JogadorDAO instance = new JogadorDAO( new AssistenteConexao());
    instance.inserir(jogador);
    String expResult = jogador.toString();
    String result = instance.buscar(2).toString();
    assertEquals(expResult, result);
    }
    
    /**
    * Test of remover method, of class JogadorDAO.
    */
    /*
    @Test
    public void testRemover() throws Exception {
        System.out.println("remover");
        Jogador jogador = null;
        JogadorDAO instance = null;
        boolean expResult = false;
        boolean result = instance.remover(jogador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of alterar method, of class JogadorDAO.
     */
    /*
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        Jogador jogador = null;
        JogadorDAO instance = null;
        boolean expResult = false;
        boolean result = instance.alterar(jogador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of buscar method, of class JogadorDAO.
     */
    /*
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        int id = 1;
        JogadorDAO instance = new JogadorDAO( new CredenciaisConexao("localhost", "gyouzafoot", "hydrocat", ""));
        Jogador expResult = new Jogador(1,"testersom",24);
        Jogador result = instance.buscar(id);
        assertEquals(expResult.toString(), result.toString());
        
    }

    /**
     * Test of getList method, of class JogadorDAO.
     */
    /* @Test
    public void testGetList() throws Exception {
    System.out.println("getList");
    JogadorDAO instance = null;
    ArrayList<Jogador> expResult = null;
    ArrayList<Jogador> result = instance.getList();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    
}
