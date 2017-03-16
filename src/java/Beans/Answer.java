/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;

/**
 *
 * @author musakolo
 */
public class Answer {
    private String text;
    private int correct=0;
    private int id;
    
     public void setID(int id){
        this.id=id ;
    }
    
    public int getID(){
        return id ;
    }
    
     public void setText(String text){
        this.text=text ;
    }
    
    public String getText(){
        return text;
    }
     public void setCorrect(int corr){
        this.correct=corr ;
    }
    
    public int getCorrect(){
        return correct ;
    }
    
}
