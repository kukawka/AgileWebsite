/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.time.LocalDate;
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
public class TakingQuizModelTest {
    
    private TakingQuizModel instance;
    public TakingQuizModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new TakingQuizModel();
    }
    
    @After
    public void tearDown() {
    }

    /**
    *   Tests if the given answers are saved.
    */
    @Test
    public void testSaveGivenAnswer() {
        int completedQuizID = 1;
        String GivenAnswer = "1";
        int expectedResult = 0;
       // int result = instance.saveGivenAnswer(completedQuizID,1,GivenAnswer);
        //System.out.println("Result: "+result);
        //assertNotSame("The answer was saved in the database",result,expectedResult);
    }
    
    /**
     * 
    *   Tests saving the completion of a quiz
    */
    @Test
    public void testSaveCompletedQuiz() {
        int userID = 2;
        int quizID = 3;
        int score = 88;
        LocalDate date = LocalDate.now();
        int expectedResult = 0;
        //int result = instance.saveCompletedQuiz(userID,quizID,score,date);
        //System.out.println("Result: "+result);
        //assertNotSame("The answer was saved in the database",result,expectedResult);
    }

    /**
     * Test of getSavedQuizID method, of class TakingQuizModel.
     */
    @Test
    public void testGetSavedQuizID() {
        System.out.println("getSavedQuizID");
        String userID = "2";
        int quizID = 1;
        int expResult = 1;
        int result = instance.getSavedQuizID(userID, quizID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    
}
