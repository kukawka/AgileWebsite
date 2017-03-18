package Beans;

import java.util.ArrayList;

/**
 *
 * @author Dagi
 */
public class QuizDetails 
{
    String title = "";
    boolean availability = false; 
    ArrayList<Question> questions = new ArrayList<>();
    String date = "";
    
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
     public void setAvailability(boolean availability){
        this.availability = availability ;
    }
    public boolean getAvailability(){
        return availability;
    }
    
    public void setQuestions(ArrayList<Question> questions){
        this.questions = questions;
    }
    public ArrayList<Question> getQuestions(){
        return questions;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return date;
    }
    
}