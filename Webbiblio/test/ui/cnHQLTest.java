/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stagiaire
 */
public class cnHQLTest {
    
    public cnHQLTest() {
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
     * Test of afficherResultat method, of class cnHQL.
     */
    @Test
    public void testAfficherResultat() {
        System.out.println("afficherResultat");
        List listResultat = null;
        cnHQL instance = new cnHQL();
        instance.afficherResultat(listResultat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeHqlQuery method, of class cnHQL.
     */
    @Test
    public void testExecuteHqlQuery() {
        System.out.println("executeHqlQuery");
        String lsHql = "";
        cnHQL instance = new cnHQL();
        instance.executeHqlQuery(lsHql);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
