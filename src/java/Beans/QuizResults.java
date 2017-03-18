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
    double average=0 ;    
    int maxi=0; 
    int mini=0 ;

    public double getAverage() {
        return average;
    }

    public int getMaxi() {
        return maxi;
    }

    public int getMini() {
        return mini;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public void setMaxi(int maxi) {
        this.maxi = maxi;
    }

    public void setMini(int mini) {
        this.mini = mini;
    }
    
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
