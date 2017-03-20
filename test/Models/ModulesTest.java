/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Beans.Module;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Krasi
 */
public class ModulesTest {
    
    public ModulesTest() {
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
     * Test of setFavModules method, of class Modules.
     */
    @Test
    public void testSetFavModules() {
        System.out.println("setFavModules");
        String user = "2";
        String IDs = "2";
        Modules instance = new Modules();
        int result = instance.setFavModules(user, IDs);
        int expResult = 0;
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of removeFavModule method, of class Modules.
     */
    @Test
    public void testRemoveFavModule() {
        System.out.println("removeFavModule");
        String user = "2";
        String module = "2";
        Modules instance = new Modules();
        int expResult = 0;
        int result = instance.removeFavModule(user, module);
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getModules method, of class Modules.
     */
    @Test
    public void testGetModules() {
        System.out.println("getModules");
        String user = "2";
        Modules instance = new Modules();
        ArrayList<Module> expResult = null;
        ArrayList<Module> expResult1 = new ArrayList<>();
        Module module = new Module();
        module.setID(1);
        module.setName("AC32008 - Theory of Computing");
        expResult1.add(module);
        ArrayList<Module> result = instance.getModules(user);
        assertNotEquals(expResult, result);
        assertEquals(expResult1.get(0).getID(), result.get(0).getID());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
