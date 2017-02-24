/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Beans.Question;
import Beans.QuizDetails;
import java.time.LocalDate;
import java.util.ArrayList;
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
public class QuizTest extends TestCase {
    private Quiz instance ;
    private LocalDate creationDate;
    
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
        instance = new Quiz();
        creationDate=null ;
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
        int quizID = 2;

        QuizDetails expResult = new QuizDetails();
        expResult.setTitle("QuizTest11");
        expResult.setAvailability(false);
        expResult.setDate("2017-02-17");
        ArrayList <Question> questions=new ArrayList<Question>() ;
        Question q1=new Question() ;
        q1.setCorrectAnswerID(0);
        q1.setQuestionText("wddd");
        q1.setExplanation("asfas");
        String[] answers=new String[4];
        answers[0]="Example Answer" ;
        answers[1]="sdsa";
        answers[2]="sdas";
        answers[3]=null ;
        questions.add(q1) ;
        
        Question q2=new Question() ;
        q1.setCorrectAnswerID(1);
        q1.setQuestionText("AAAA");
        q1.setExplanation("ffff");
        answers[0]="ssss" ;
        answers[1]="vse taq brat";
        answers[2]=null ;
        answers[3]=null ;
        questions.add(q2) ;
        
        Question q3=new Question() ;
        q1.setCorrectAnswerID(-1);
        q1.setQuestionText("ffff");
        q1.setExplanation("www");
        answers[0]=null;
        answers[1]=null;
        answers[2]=null;
        answers[3]=null ;
        questions.add(q3) ;
        
        expResult.setQuestions(questions);
       
        QuizDetails result = instance.getQuiz(quizID);

        assertEquals("The right title wasn't returned", expResult.getTitle(), result.getTitle());
        assertEquals("The right title wasn't returned", expResult.getDate(), result.getDate());
        assertEquals("The right title wasn't returned", expResult.getTitle(), result.getTitle());
        assertEquals("The right title wasn't returned", expResult.getTitle(), result.getTitle());
        //assertEquals(expResult, result);
        assertNotNull("Database connection failed", result) ;
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
        int expResult = 0;
        int result = instance.SubmitAnswer(answerText, correct, questionNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }    
}
