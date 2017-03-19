package Beans;

/**
 *
 * @author Dagi
 */
public class LoggedIn {
    boolean logedin = false;
    String Username = null;
    String Type = null;
    
    public void LogedIn(){
    }
    
    public void setUsername(String name){
        this.Username = name;
    }
    public String getUsername(){
        return Username;
    }
    
    public void setType(String type){
        this.Type = type;
    }
    public String getType(){
        return Type;
    }
   
    public void setLogedin(){
        logedin = true;
    }
    public void setLogedout(){
        logedin = false;
    }
    
    public void setLoginState(boolean logedin){
        this.logedin = logedin;
    }
    public boolean getlogedin(){
        return logedin;
    }
}