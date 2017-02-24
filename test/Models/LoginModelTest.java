/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Util.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dagi
 */
public class LoginModelTest extends TestCase {
    
    private LoginModel instance ;
    
    public LoginModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
      
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new LoginModel();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of authenticateLogin method, of class LoginModel.
     */
    @Test
    public void testAuthenticateLogin() {
        System.out.println("authenticateLogin");
        String username = "3";
        String password = "test1";
       
        String expResult = "Staff";
        String result = instance.authenticateLogin(username, password);
        assertEquals("The right user type wasn't returned",expResult, result);
        assertNotNull("Authentication failed",result) ;
    }
    
}
