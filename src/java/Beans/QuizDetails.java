/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;

/**
 *
 * @author Dagi
 */
public class QuizDetails {
    String title="" ;
    boolean availability=false ; 
    ArrayList<Question> questions = new ArrayList<Question>();
    String date = "" ;
    
    public void setTitle(String title){
        this.title=title ;
    }
    
    public String getTitle(){
        return title ;
    }
     public void setAvailability(boolean availability){
        this.availability=availability ;
    }
    
    public boolean getAvailability(){
        return availability ;
    }
    
      public void setQuestions(ArrayList<Question> questions){
        this.availability=availability ;
    }
    
    public ArrayList<Question> getQuestions(){
        return questions ;
    }
    
    public void setDate(String date){
        this.date=date ;
    }
    
    public String getDate(){
        return date ;
    }
    
    
}
