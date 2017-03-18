package Beans;

/**
 *
 * @author Krasi + Philipp
 */
public class Quiz 
{
    String name = "";
    int id = 0;
    boolean completed;
    
    public void setCompletion(boolean comp) { this.completed = comp; }
    public boolean getCompletion() { return completed; }
    
    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
    
    public void setID(int id) { this.id = id; }
    public int getID() { return id; }

}   