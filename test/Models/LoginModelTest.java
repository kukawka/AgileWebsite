/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Util.DBConnection;
import java.sql.Connection;
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
public class LoginModelTest {
    
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
        String password = "test";
        LoginModel instance = new LoginModel();
        String expResult = "Staff";
        String result = instance.authenticateLogin(username, password);
        assertEquals("The right user type wasn't returned",expResult, result);
        assertNull("Authentication failed",result) ;
    }
    
}
