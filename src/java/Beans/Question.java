/*
 * This class is a part of refactoring process, extracted fields from the QuizDetails into a new class.
 */
package Beans;

import java.util.ArrayList;

/**
 *
 * @author Dagi
 */
public class Question {
    //Refactoring- renamed the field so that it is more descriptive 
    String questionText="" ;
    int ID;
    
    //Refactoring- renamed the field so that it is more descriptive 
    String answerExplanation="" ;
    //int correctAnswerID=-1 ;
    ArrayList <Answer> answers ;
    //String[] answers=new String[4] ;
    
    //Refactoring- renamed the method so that it would match up the field and make more sense- the previous name suggested retuning a whole Question object rather than a field
    public void setQuestionText(String questionText){
        this.questionText=questionText ;
    }
    
    public String getQuestionText(){
        return questionText ;
    }
    
    public void setQuestionID(int id){
        this.ID=id ;
    }
    
    public int getQuestionID(){
        return ID ;
    }
    
    public void setExplanation(String answerExplanation){
        this.answerExplanation=answerExplanation ;
    }
    
    public String getExplanation(){
        return answerExplanation ;
    }
    
    
     public void setAnswers(ArrayList<Answer> answers){
        this.answers=answers ;
    }
    
    public ArrayList<Answer> getAnswers(){
        return answers ;
    }
}
