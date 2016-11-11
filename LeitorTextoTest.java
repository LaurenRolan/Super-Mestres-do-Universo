/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicaixa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel
 */
public class LeitorTextoTest {
    
    public LeitorTextoTest() {
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
     * Test of lerArquivo method, of class LeitorTexto.
     */
    @Test
    public void testLerArquivo() {
        System.out.println("lerArquivo");
        String nomeArquivo = "teste1.txt";
        LeitorTexto instance = new LeitorTexto();
        String expResult = "Este eh um teste super bom!";
        String result = instance.lerArquivo(nomeArquivo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
