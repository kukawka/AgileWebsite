/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Beans.Module;
import Beans.ProgrammeOfStudy;
import Beans.Quiz;
import java.sql.SQLException;
import java.util.ArrayList;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
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
public class MainPageModelTest extends TestCase {
    
    private ProgrammeOfStudy pos;
    private Module mod;
    private Quiz qu;
    public MainPageModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         pos = new ProgrammeOfStudy();
         mod = new Module();
         qu = new Quiz();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPOS method, of class MainPageModel.
     */
    
    @Test
    public void testGetPOS() throws SQLException {
        System.out.println("getPOS");
        MainPageModel instance = new MainPageModel();
        ArrayList<ProgrammeOfStudy> expResult = new ArrayList<ProgrammeOfStudy>(2);
        pos.setID(1);
        pos.setName("Computing Science");
        expResult.add(0,pos);
        ProgrammeOfStudy pos1 = new ProgrammeOfStudy();
        pos1.setID(2);
        pos1.setName("Applied Computing");
        expResult.add(1,pos1);
        ArrayList<ProgrammeOfStudy> result = instance.getPOS();
        assertEquals("The programmes of study are returned",expResult.get(1).getName(), result.get(1).getName());
        assertEquals("The programmes of study are returned",expResult.get(1).getID(), result.get(1).getID());
        assertEquals("The programmes of study are returned",expResult.get(0).getID(), result.get(0).getID());
        assertEquals("The programmes of study are returned",expResult.get(0).getName(), result.get(0).getName());
        //assertEquals("The programmes of study is not returned",expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
       assertNotNull("Database connection failed", result) ;
    }

    /**
     * Test of getModules method, of class MainPageModel.
     */
    @Test
    public void testGetModules() {
        System.out.println("getModules");
        MainPageModel instance = new MainPageModel();
        ArrayList<Module> expResult = new ArrayList<Module>();
        ArrayList<Module> result = instance.getModules(1,"2");
        //int ID = 1;
        mod.setID(1);
        mod.setName("AC32008 - Theory of Computing");
        expResult.add(mod);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals("The module are returned",expResult.get(0).getName(), result.get(0).getName());
        assertNotNull("Database connection failed", result) ;
    }

    /**
     * Test of getQuizzes method, of class MainPageModel.
     */
    
    @Test
    public void testGetQuizzesStaff() {
        MainPageModel instance = new MainPageModel();
        ArrayList<Quiz> expResultStaff = new ArrayList<>();
        ArrayList<Quiz> resultStaff = instance.getQuizzes(1, "Staff",3);
        qu.setName("testing_update_quiz");
        expResultStaff.add(qu);
        assertEquals("The quizzes are returned",expResultStaff.get(0).getName(),resultStaff.get(0).getName());
        assertNotNull("Database connection failed", resultStaff) ;
    }
    public void testGetQuizzesStudent() {
        MainPageModel instance = new MainPageModel();
        ArrayList<Quiz> expResultStudent = new ArrayList<>();
        ArrayList<Quiz> resultStudent = instance.getQuizzes(1,"Student",2);
        Quiz qu1 = new Quiz();
        qu1.setName("  Quiz about Lecturers");
        expResultStudent.add(qu1);
        assertEquals("The quizzes are returned",expResultStudent.get(0).getName(),resultStudent.get(0).getName());
        assertNotNull("Database connection failed", resultStudent) ;
    }
    public void testGetQuizzesStudentAvailability() {
        MainPageModel instance = new MainPageModel();
        ArrayList<Quiz> expResultStudent = new ArrayList<>();
        ArrayList<Quiz> resultStudent = instance.getQuizzes(1,"Student",2);
        Quiz qu1 = new Quiz();
        qu1.setName(" Quiz unavailable for Students");
        expResultStudent.add(qu1);
        assertNotEquals("The quizzes are returned",expResultStudent.get(0).getName(),resultStudent.get(0).getName());
        assertNotNull("Database connection failed", resultStudent) ;
    }
    public void testGetQuizzesStudentCompleted() {
        MainPageModel instance = new MainPageModel();
        ArrayList<Quiz> expResultStudent = new ArrayList<>();
        ArrayList<Quiz> resultStudent = instance.getQuizzes(1,"Student",2);
        Quiz qu1 = new Quiz();
        qu1.setName("  Quiz about Lecturers");
        qu1.setCompletion(true);
        expResultStudent.add(qu1);
        Quiz qu2= new Quiz();
        qu2.setName("  Agile Best module EU");
        qu2.setCompletion(false);
        expResultStudent.add(qu2);
        System.out.println("Stduent_hardcoded: " + expResultStudent.get(0).getName());
        assertEquals("The quizzes are returned",expResultStudent.get(0).getName(),resultStudent.get(0).getName());
        assertEquals("The quizzes are returned",expResultStudent.get(0).getCompletion(),resultStudent.get(0).getCompletion());
        //assertEquals("The quizzes are returned",expResultStudent.get(1).getName(),resultStudent.get(1).getName());
        //assertEquals("The quizzes are returned",expResultStudent.get(1).getCompletion(),resultStudent.get(1).getCompletion());
        assertNotNull("Database connection failed", resultStudent) ;
    }
    
}
