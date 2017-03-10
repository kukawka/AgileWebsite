/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class ResultTest {
    
    private Result instance;
    
    public ResultTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Result();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getStudentResult method, of class Result.
     */
    @Test
    public void testGetStudentResult() {     
        System.out.println("test student result");
        int studentID = 2;
        int quizID = 1;
        
        int expResult = -1;
        
        int result = instance.getStudentResult(studentID, quizID);
        assertNotSame("An ID was generated for the result.", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
