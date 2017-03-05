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
    
    //Refactoring- renamed the field so that it is more descriptive 
    String answerExplanation="" ;
    //int correctAnswerID=-1 ;
    ArrayList <Integer> correctAnswers ;
    ArrayList <String> answers ;  
    //String[] answers=new String[4] ;
    
    //Refactoring- renamed the method so that it would match up the field and make more sense- the previous name suggested retuning a whole Question object rather than a field
    public void setQuestionText(String questionText){
        this.questionText=questionText ;
    }
    
    public String getQuestionText(){
        return questionText ;
    }
    
    public void setExplanation(String answerExplanation){
        this.answerExplanation=answerExplanation ;
    }
    
    public String getExplanation(){
        return answerExplanation ;
    }
    
     public void setCorrectAnswers(ArrayList <Integer> correctAnswers){
        this.correctAnswers=correctAnswers ;
    }
    
    public ArrayList<Integer> getCorrectAnswers(){
        return correctAnswers ;
    }
    
     public void setAnswers(ArrayList<String> answers){
        this.answers=answers ;
    }
    
    public ArrayList<String> getAnswers(){
        return answers ;
    }
    
    
    
}
