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
public class QuizResults {
    ArrayList<Integer> scores=new ArrayList<>() ;
    ArrayList<String>surnames=new ArrayList<>() ;
    ArrayList<String>firstnames=new ArrayList<>() ;
    ArrayList<String> matricNum=new ArrayList<>() ;
    ArrayList<Integer> attempts=new ArrayList<>() ;
    ArrayList<String> dates=new ArrayList<>() ;
    
    public void setScores(ArrayList<Integer> scores){
        this.scores=scores ;
    }
    
    public void setAttempts(ArrayList<Integer> attempts){
        this.attempts=attempts ;
    }
    
    public void setSurnames(ArrayList<String>surnames){
        this.surnames=surnames ;
    }
    
    public void setDates(ArrayList<String>dates){
        this.dates=dates ;
    }
    
    public void setFirstnames(ArrayList<String>firstnames){
        this.firstnames=firstnames ;
    }
    
    public void setMatricNum(ArrayList<String> matricNum){
        this.matricNum=matricNum ;
    }
    
    public ArrayList<Integer> getScores(){
        return scores ;
    }
    
    public ArrayList<Integer> getAttempts(){
        return attempts ;
    }
    
    public ArrayList<String> getFirstnames(){
        return firstnames ;
    }
    
        public ArrayList<String> getSurnames(){
        return surnames ;
    }
        
    public ArrayList<String> getMatricNum(){
        return matricNum ;
    }
    
    public ArrayList<String> getDates(){
        return dates ;
    }
    
    
    
}
