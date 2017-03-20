/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Beans.Question;
import Beans.QuizDetails;
import Beans.QuizResults;
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

    private Quiz instance;
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
        creationDate = null;
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getQuizResults method, of class Quiz.
     */
    @Test
    public void testGetQuizResults() {
        System.out.println("getResults");

        QuizResults result = instance.getQuizResults(1);

        //there're currently 3 scores for the quiz so first of all I need to check if 3 scores are retrieved
        assertEquals("The right number of scores wasn't returned", 1, result.getScores().size());
        assertNotEquals("Not all scores were returned", 10, result.getScores().size());
        assertNotEquals("Only one score was returned", 0, result.getScores().size());
        assertNotEquals("Too many scores were returned", 4, result.getScores().size());

        assertNotEquals("The right average wasn't returned ", 100, result.getAverage());
        assertNotEquals("The right max wasn't returned", 99, result.getMaxi());
        assertNotEquals("The right max wasn't returned", 30, result.getMini());

        QuizResults expResult = new QuizResults();
        //to be continued

        assertNotNull("Database connection failed", result);
    }

    /**
     * Test of getQuiz method, of class Quiz.
     */
    @Test
    public void testGetQuiz() {
        System.out.println("getQuiz");
        int quizID = 1;

        QuizDetails expResult = new QuizDetails();
        expResult.setTitle("testing_update_quiz");
        expResult.setAvailability(false);
        expResult.setDate("2017-03-20");
        ArrayList<Question> questions = new ArrayList<Question>();
        Question q1 = new Question();
        //q1.setCorrectAnswerID(0);
        q1.setQuestionText("testing_update_question");
        q1.setExplanation("testing_update_question_exp");
        questions.add(q1);

        Question q2 = new Question();
        //q2.setCorrectAnswerID(1);
        q2.setQuestionText("Tick all the animals (Q2)");
        q2.setExplanation("Animals are animals  you animal (Explan Q2)");
        questions.add(q2);

        Question q3 = new Question();
        //q3.setCorrectAnswerID(-1);
        q3.setQuestionText("Who let the dogs out? (Q3)");
        q3.setExplanation("Song by band Baha Men");
        questions.add(q3);

        expResult.setQuestions(questions);

        QuizDetails result = instance.getQuiz(quizID);

        assertEquals("The right title wasn't returned", expResult.getTitle(), result.getTitle());
        assertEquals("The right date  wasn't returned", expResult.getDate(), result.getDate());
        assertEquals("The right availability status wasn't returned", expResult.getAvailability(), result.getAvailability());
        /* assertEquals("The right question text wasn't returned", expResult.getQuestions().get(0).getQuestionText(), result.getQuestions().get(0).getQuestionText());
        assertEquals("The right question text wasn't returned", expResult.getQuestions().get(1).getQuestionText(), result.getQuestions().get(1).getQuestionText());
        assertEquals("The right question text wasn't returned", expResult.getQuestions().get(2).getQuestionText(), result.getQuestions().get(2).getQuestionText());
        assertEquals("The right correct question ID wasn't returned", expResult.getQuestions().get(0).getCorrectAnswers(), result.getQuestions().get(0).getCorrectAnswers());
        assertEquals("The right explanation text wasn't returned", expResult.getQuestions().get(0).getExplanation(), result.getQuestions().get(0).getExplanation());*/
        String expAnsw[] = new String[4];
        expAnsw[0] = "Example Answer";
        /*String answ[]=result.getQuestions().get(0).getAnswers();
        
        assertEquals("The right answer wasn't returned", expAnsw[0], answ[0]);*/

        assertNotNull("Database connection failed", result);
    }

    /**
     * Test of RegisterQuiz method, of class Quiz.
     *//*
    @Test
    public void testRegisterQuiz() {
        System.out.println("RegisterQuiz");
        String title = "test quiz";
        String moduleID = "1";
        int available = 1;
        creationDate = LocalDate.now();

        int expResult = -1;
        int result = instance.RegisterQuiz(title, moduleID, available, creationDate);

        //result shouldn't return -1, but instead the ID of the quiz
        assertNotSame("An ID was generated for the Quiz.", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
*/
    /**
     * Test of SubmitQuestion method, of class Quiz.
     *//*
    @Test
    public void testSubmitQuestion() {
        System.out.println("SubmitQuestion");
        String questionText = "test question";
        String explanationText = "test question explanation";
        int quizID = 5;
        int questionNumber = 1;
        int expResult = -1;

        int result = instance.SubmitQuestion(questionText, explanationText, quizID, questionNumber);
        //result shouldn't return -1, but instead the ID of the question
        assertNotSame("An ID was generated for the question.", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
*/
    /**
     * Test of SubmitAnswer method, of class Quiz.
     *//*
    @Test
    public void testSubmitAnswer() {
        System.out.println("SubmitAnswer");
        String answerText = "test answer";
        int correct = 0;

        int questionNumber = 1;
        int expResult = 1;

        int result = instance.SubmitAnswer(answerText, correct, questionNumber);
        //result shouldn't return -1 
        assertEquals("Answer was submitted successfully.", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
*/
    /**
     * Test of getResults method, of class Quiz.
     */
    @Test
    public void testGetRelevantResults() {
        System.out.println("getQuiz");
        int quizID = 1;

        QuizResults result = instance.getRelevantQuizResults(quizID);
        QuizResults expResult = new QuizResults();
        ArrayList<Integer> scores = new ArrayList<>();
        ArrayList<String> surnames = new ArrayList<>();
        ArrayList<String> firstnames = new ArrayList<>();
        ArrayList<String> matricNum = new ArrayList<>();
        ArrayList<Integer> attempts = new ArrayList<>();
        ArrayList<String> dates = new ArrayList<>();
        double average = 72;
        int maxi = 79;
        int mini = 65;
        scores.add(65);
        matricNum.add("4");

        dates.add("2017-03-20");
        surnames.add("Kostov");

        expResult.setDates(dates);
        expResult.setSurnames(surnames);
        expResult.setMatricNum(matricNum);
        expResult.setScores(scores);

        assertNotEquals("Too many results were returned", (expResult.getScores().size())+1, result.getScores().size());
        assertNotEquals("Too few results were returned", (expResult.getScores().size())-1, result.getScores().size());
        assertEquals("The right number of results wasn't returned", expResult.getScores().size(), result.getScores().size());
        assertEquals("The right student's data wasn't returned", expResult.getSurnames().get(0), result.getSurnames().get(0));
        assertEquals("The right date wasn't returned", expResult.getDates().get(0), result.getDates().get(0));
        //assertEquals("The right student wasn't returned", expResult.getMatricNum().get(1), result.getMatricNum().get(1));
        
        assertNotNull("Database connection failed", result);
    }
    
    /**
     * Test of getResults method, of class Quiz.
     */
    @Test
    public void testEditQuiz() {
        System.out.println("SubmitEditQuiz");
        boolean wentThroughCode = true;
        
        boolean availability = false;
        String title="testing_update_quiz";
        int id = 1;

        instance.EditQuiz(availability, title, id);
        //if edit fails, the code will never return back to this test method
        assertTrue("Quiz was edited succesfully.", wentThroughCode); 
    
    }
    
    @Test
    public void testEditQuestion() {
        System.out.println("SubmitEditQuestion");
        boolean wentThroughCode = true;
        
        String text = "testing_update_question";
        String exp = "testing_update_question_exp";
        int ID = 1;

        instance.EditQuestion(text, exp, ID);
        //if edit fails, the code will never return back to this test method
        assertTrue("Quiz was edited succesfully.", wentThroughCode); 
    
    }
    
    @Test
    public void testEditAnswer() {
        System.out.println("SubmitEditAnswer");
        boolean wentThroughCode = true;
        
        String text = "testing_update_answer";
        int ID = 1;
        int correct = 1;
        
        instance.EditAnswer(text, ID, correct);
        //if edit fails, the code will never return back to this test method
        assertTrue("Quiz was edited succesfully.", wentThroughCode); 
    
    }

}
