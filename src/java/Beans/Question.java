/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Dagi
 */
public class Question {
    String question="" ;
    String explanation="" ;
    int correctAnswerID=-1 ;
    String[] answers=new String[4] ;
    
    public void setQuestion(String question){
        this.question=question ;
    }
    
    public String getQuestion(){
        return question ;
    }
    
    public void setExplanation(String explanation){
        this.explanation=explanation ;
    }
    
    public String getExplanation(){
        return explanation ;
    }
    
     public void setCorrectAnswerID(int correctQuestionID){
        this.correctAnswerID=correctQuestionID ;
    }
    
    public int getCorrectAnswerID(){
        return correctAnswerID ;
    }
    
     public void setAnswers(String[] answers){
        this.answers=answers ;
    }
    
    public String[] getAnswers(){
        return answers ;
    }
    
    
    
}
