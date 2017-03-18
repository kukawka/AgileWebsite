package Beans;

import java.util.ArrayList;

/**
 *
 * @author Krasi
 */
public class ProgrammeOfStudy 
{
    String name = "";
    int id = 0;
    ArrayList<Module> modules = new ArrayList<>();
    
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
        return id;
    }
   
    public void setModules(ArrayList<Module> modules){
        this.modules = modules ;
    }
    public ArrayList<Module> getModules(){
        return modules ;
    }

}