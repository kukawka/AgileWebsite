/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;
import java.util.Date;
/**
 *
 * @author Dagi
 */
public class Scheduler extends Thread {
    private Date goAt;
    private String command;
    public Scheduler(Date goAt, String command) {
        this.goAt = goAt;
        this.command = command;
    }
    public void start() {
        super.start();
    }
    public void run() {
        while (!goAt.equals(new Date())) {} //Wait until the dates are equal
        runCommand(command); //In the real thing, this runs the command.
    }
    public void runCommand(String command) {
        System.out.println("Command: " + command);
    }
}
    

