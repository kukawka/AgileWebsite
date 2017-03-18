package Beans;

import java.util.ArrayList;

/**
 *
 * @author Dagi
 */
public class QuizResults 
{
    ArrayList<Integer> scores    = new ArrayList<>();
    ArrayList<Integer> attempts  = new ArrayList<>();
    ArrayList<String> surnames   = new ArrayList<>();
    ArrayList<String> firstnames = new ArrayList<>();
    ArrayList<String> matricNum  = new ArrayList<>();
    ArrayList<String> dates      = new ArrayList<>();
    double average = 0;    
    int maxi = 0; 
    int mini = 0;
    
    public void setAverage(double average) {
        this.average = average;
    }
    public double getAverage() {
        return average;
    }

    public void setMaxi(int maxi) {
        this.maxi = maxi;
    }
    public int getMaxi() {
        return maxi;
    }

    public void setMini(int mini) {
        this.mini = mini;
    }
    public int getMini() {
        return mini;
    }

    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }
    public ArrayList<Integer> getScores() {
        return scores;
    }
    
    public void setAttempts(ArrayList<Integer> attempts) {
        this.attempts = attempts;
    }
    public ArrayList<Integer> getAttempts() {
        return attempts;
    }
    
    public void setSurnames(ArrayList<String>surnames) {
        this.surnames = surnames;
    }
    public ArrayList<String> getSurnames() {
        return surnames;
    }
    
    public void setDates(ArrayList<String>dates) {
        this.dates = dates;
    }
    public ArrayList<String> getDates() {
        return dates;
    }
    
    public void setFirstnames(ArrayList<String>firstnames) {
        this.firstnames = firstnames;
    }
    public ArrayList<String> getFirstnames() {
        return firstnames;
    }
    
    public void setMatricNum(ArrayList<String> matricNum) {
        this.matricNum = matricNum;
    }
    public ArrayList<String> getMatricNum() {
        return matricNum;
    }
     
}