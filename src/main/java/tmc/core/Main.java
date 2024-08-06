package tmc.core;

import java.io.IOException;

/**
 *
 * @author Luca Kölzsch
 */
public class Main {

    public static void main(String[] args) {
        Game g = new Game(1);
        
        //Herr Schmietendorf, probieren Sie hierüber die Lade-funtion aus, wenn Sie wollen
        /*
        g = g.load(); 
        g.getCompany().setName("Main Street Capital");
        try {
            g.save();
        } catch (IOException ex) {
        }
        System.out.println(g.getCompany().getName()); 
        */
        
        
        try {
            g = g.load();
        } catch (Exception e) {
        }
        System.out.println(g.getCompany().getName()); 
        g.start();
        
    }

}
