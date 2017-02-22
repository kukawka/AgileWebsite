/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;

/**
 *
 * @author Krasi
 */
public class ProgrammeOfStudy {
    String name="" ;
    int id=0 ;
    ArrayList<Module> modules=new ArrayList<Module>() ;
    
    public void setName(String name){
        this.name=name ;
    }
    
    public String getName(){
        return name ;
    }
    
    public void setID(int id){
        this.id=id ;
    }
    
    public int getID(){
        return id;
    }
   
    public void setModules(ArrayList<Module> modules){
        this.modules=modules ;
    }
    
    public ArrayList<Module> getModule(){
        return modules ;
    }

}
