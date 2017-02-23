/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Beans.QuizDetails;
import java.time.LocalDate;
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
public class QuizTest {
    
    public QuizTest() {
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
     * Test of getQuiz method, of class Quiz.
     */
    @Test
    public void testGetQuiz() {
        System.out.println("getQuiz");
        int quizID = 0;
        Quiz instance = new Quiz();
        QuizDetails expResult = null;
        QuizDetails result = instance.getQuiz(quizID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RegisterQuiz method, of class Quiz.
     */
    @Test
    public void testRegisterQuiz() {
        System.out.println("RegisterQuiz");
        String title = "";
        String moduleID = "";
        int available = 0;
        LocalDate creationDate = null;
        Quiz instance = new Quiz();
        int expResult = 0;
        int result = instance.RegisterQuiz(title, moduleID, available, creationDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SubmitQuestion method, of class Quiz.
     */
    @Test
    public void testSubmitQuestion() {
        System.out.println("SubmitQuestion");
        String questionText = "";
        String explanationText = "";
        int quizID = 0;
        int questionNumber = 0;
        Quiz instance = new Quiz();
        int expResult = 0;
        int result = instance.SubmitQuestion(questionText, explanationText, quizID, questionNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SubmitAnswer method, of class Quiz.
     */
    @Test
    public void testSubmitAnswer() {
        System.out.println("SubmitAnswer");
        String answerText = "";
        int correct = 0;
        int questionID = 0;
        int questionNumber = 0;
        Quiz instance = new Quiz();
        int expResult = 0;
        int result = instance.SubmitAnswer(answerText, correct, questionNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
