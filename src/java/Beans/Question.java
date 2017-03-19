package Beans;

import java.util.ArrayList;

/**
 *
 * @author Dagi
 */
public class Question 
{
    String questionText = "";
    int ID;
    
    String answerExplanation = "";
    ArrayList <Answer> answers;
    
    public void setQuestionText(String questionText){
        this.questionText = questionText;
    }
    public String getQuestionText(){
        return questionText;
    }
    
    public void setQuestionID(int id){
        this.ID = id;
    }
    public int getQuestionID(){
        return ID;
    }
    
    public void setExplanation(String answerExplanation){
        this.answerExplanation = answerExplanation;
    }
    public String getExplanation(){
        return answerExplanation;
    }
    
    public void setAnswers(ArrayList<Answer> answers){
        this.answers = answers;
    }
    public ArrayList<Answer> getAnswers(){
        return answers;
    }
    
}