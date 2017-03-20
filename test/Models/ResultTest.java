/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
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
        int studentID = 2;
        int quizID = 1;
        int expResult = 1;
        int result = instance.getStudentResult(studentID, quizID);
        assertSame("An ID was generated for the result.", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getStudentAnswers method, of class Result.
     */
    @Test
    public void testGetStudentAnswers() {
        System.out.println("getStudentAnswers");
        int quizID = 0;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getStudentAnswers(quizID);
        assertNotEquals("The function does not return answers", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getStudentScore method, of class Result.
     */
    @Test
    public void testGetStudentScore() {
        System.out.println("getStudentScore");
        int quizID = 1;
        int expResult = 100;
        int result = instance.getStudentScore(quizID);
        System.out.println(result);
        assertSame("Getting student score test is successfull.",expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("Getting student score test is not working.");
    }

    /**
     * Test of getQuizDate method, of class Result.
     */
    @Test
    public void testGetQuizDate() {
        System.out.println("getQuizDate");
        int quizID = 1;
        String expResult = "2017-03-20";
        String result = instance.getQuizDate(quizID);
        System.out.println(result);
        assertEquals("The date of the completed quiz was not successfully returned.", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
