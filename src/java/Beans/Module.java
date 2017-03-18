package Beans;

/**
 *
 * @author Krasi
 */
public class Module 
{
    String name = "";
    int id = 0;
    int choice = 0;
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void setID(int id){
        this.id = id;
    }
    public int getID(){
        return id ;
    }
    
    public void setChoice(int choice){
        this.choice = choice;
    }
    public int getChoice(){
        return choice;
    }
    
}