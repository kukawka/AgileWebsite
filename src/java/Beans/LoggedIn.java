/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Dagi
 */
public class LoggedIn {
    boolean logedin=false;
    String Username=null;
    //String First_name=null ;
    public void LogedIn(){
        
    }
    
    public void setUsername(String name){//where did that come from?????
        this.Username=name;
    }
    public String getUsername(){
        return Username;
    }
   
    public void setLogedin(){
        logedin=true;
    }
    public void setLogedout(){
        logedin=false;
    }
    
    public void setLoginState(boolean logedin){
        this.logedin=logedin;
    }
    public boolean getlogedin(){
        return logedin;
    }
}
