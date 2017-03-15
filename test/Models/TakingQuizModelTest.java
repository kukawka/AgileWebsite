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
    public void testSavingAnswer() {
        int QuestionID = 2;
        int GivenAnswer = 3;
        int expectedResult = 0;
        int result = instance.savingGivenAnswer(QuestionID,GivenAnswer);
        System.out.println("Result: "+result);
        assertNotSame("The answer was saved in the database",result,expectedResult);
    }
    
    /**
    *   Tests saving the completion of a quiz
    */
    @Test
    public void testSaveCompletedQuiz() {
        int userID = 2;
        int quizID = 3;
        int score = 88;
        LocalDate date = LocalDate.now();
        int expectedResult = 0;
        int result = instance.saveCompletedQuiz(userID,quizID,score,date);
        System.out.println("Result: "+result);
        assertNotSame("The answer was saved in the database",result,expectedResult);
    }
    
    
    
}
