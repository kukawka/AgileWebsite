/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
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
public class DBConnectionTest extends TestCase{
    private Connection result ;
    
    public DBConnectionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        result = DBConnection.createConnection();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createConnection method, of class DBConnection.
     */
    @Test
    public void testCreateConnection() {
        System.out.println("createConnection");
        
        assertNotNull("The connection was not established",result);
    }
    
}
