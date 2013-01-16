/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cb;

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
public class CyberMUT1_2openLibTest {
    
    public CyberMUT1_2openLibTest() {
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
     * Test of TpeToPassPhrase method, of class CyberMUT1_2openLib.
     */
    @Test
    public void testTpeToPassPhrase() {
        System.out.println("TpeToPassPhrase");
        CyberMUT1_2openLib instance = null;
        String expResult = "";
        String result = instance.TpeToPassPhrase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TpeToBankServer method, of class CyberMUT1_2openLib.
     */
    @Test
    public void testTpeToBankServer() {
        System.out.println("TpeToBankServer");
        CyberMUT1_2openLib instance = null;
        String expResult = "";
        String result = instance.TpeToBankServer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CreerFormulaireHmac method, of class CyberMUT1_2openLib.
     */
    @Test
    public void testCreerFormulaireHmac() throws Exception {
        System.out.println("CreerFormulaireHmac");
        String montant = "";
        String reference = "";
        String textelibre = "";
        String url_retour = "";
        String url_retour_ok = "";
        String url_retour_err = "";
        String langue = "";
        String societe = "";
        String textebouton = "";
        CyberMUT1_2openLib instance = null;
        String expResult = "";
        String result = instance.CreerFormulaireHmac(montant, reference, textelibre, url_retour, url_retour_ok, url_retour_err, langue, societe, textebouton);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TesterHmac method, of class CyberMUT1_2openLib.
     */
    @Test
    public void testTesterHmac() throws Exception {
        System.out.println("TesterHmac");
        String HMAC = "";
        String date_commande = "";
        String montant = "";
        String reference = "";
        String textelibre = "";
        String coderetour = "";
        String retourPLUS = "";
        CyberMUT1_2openLib instance = null;
        String expResult = "";
        String result = instance.TesterHmac(HMAC, date_commande, montant, reference, textelibre, coderetour, retourPLUS);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CreerAccuseReception method, of class CyberMUT1_2openLib.
     */
    @Test
    public void testCreerAccuseReception() {
        System.out.println("CreerAccuseReception");
        String MacOk = "";
        CyberMUT1_2openLib instance = null;
        String expResult = "";
        String result = instance.CreerAccuseReception(MacOk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isMsgAuth method, of class CyberMUT1_2openLib.
     */
    @Test
    public void testIsMsgAuth() {
        System.out.println("isMsgAuth");
        String MacOk = "";
        CyberMUT1_2openLib instance = null;
        boolean expResult = false;
        boolean result = instance.isMsgAuth(MacOk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPayment method, of class CyberMUT1_2openLib.
     */
    @Test
    public void testIsPayment() {
        System.out.println("isPayment");
        String CodeRetour = "";
        CyberMUT1_2openLib instance = null;
        boolean expResult = false;
        boolean result = instance.isPayment(CodeRetour);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isTestPayment method, of class CyberMUT1_2openLib.
     */
    @Test
    public void testIsTestPayment() {
        System.out.println("isTestPayment");
        String CodeRetour = "";
        CyberMUT1_2openLib instance = null;
        boolean expResult = false;
        boolean result = instance.isTestPayment(CodeRetour);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTPE method, of class CyberMUT1_2openLib.
     */
    @Test
    public void testGetTPE() {
        System.out.println("getTPE");
        CyberMUT1_2openLib instance = null;
        String expResult = "";
        String result = instance.getTPE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVersion method, of class CyberMUT1_2openLib.
     */
    @Test
    public void testGetVersion() {
        System.out.println("getVersion");
        CyberMUT1_2openLib instance = null;
        String expResult = "";
        String result = instance.getVersion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBankServer method, of class CyberMUT1_2openLib.
     */
    @Test
    public void testGetBankServer() {
        System.out.println("getBankServer");
        CyberMUT1_2openLib instance = null;
        String expResult = "";
        String result = instance.getBankServer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHash method, of class CyberMUT1_2openLib.
     */
    @Test
    public void testGetHash() {
        System.out.println("getHash");
        CyberMUT1_2openLib instance = null;
        String expResult = "";
        String result = instance.getHash();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCtlHmac method, of class CyberMUT1_2openLib.
     */
    @Test
    public void testGetCtlHmac() throws Exception {
        System.out.println("getCtlHmac");
        CyberMUT1_2openLib instance = null;
        String expResult = "";
        String result = instance.getCtlHmac();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculerMAC method, of class CyberMUT1_2openLib.
     */
    @Test
    public void testCalculerMAC() throws Exception {
        System.out.println("calculerMAC");
        String MacChamps = "";
        CyberMUT1_2openLib instance = null;
        String expResult = "";
        String result = instance.calculerMAC(MacChamps);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class CyberMUT1_2openLibImpl extends CyberMUT1_2openLib {

        public CyberMUT1_2openLibImpl() throws Exception {
            super("", "");
        }

        public String TpeToPassPhrase() {
            return "";
        }

        public String TpeToBankServer() {
            return "";
        }
    }
}
