/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Javier
 */
public class ModuleChoices {
    String name="" ;
    int id=0 ;
    //ArrayList<Quiz> quiz=new ArrayList<Quiz>() ;
    
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
        return id ;
    }
}
