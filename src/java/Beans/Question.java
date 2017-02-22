/*
 * This class is a part of refactoring process, extracted fields from the QuizDetails into a new class.
 */
package Beans;

/**
 *
 * @author Dagi
 */
public class Question {
    //Refactoring- renamed the field so that it is more descriptive 
    String questionText="" ;
    
    //Refactoring- renamed the field so that it is more descriptive 
    String answerExplanation="" ;
    int correctAnswerID=-1 ;
    String[] answers=new String[4] ;
    
    //Refactoring- renamed the method so that it would match up the field and make more sense- the previous name suggested retuning a whole Question object rather than a field
    public void setQuestionText(String questionText){
        this.questionText=questionText ;
    }
    
    public String getQuestionText(){
        return questionText ;
    }
    
    public void setExplanation(String explanation){
        this.answerExplanation=answerExplanation ;
    }
    
    public String getExplanation(){
        return answerExplanation ;
    }
    
     public void setCorrectAnswerID(int correctAnswerID){
        this.correctAnswerID=correctAnswerID ;
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
