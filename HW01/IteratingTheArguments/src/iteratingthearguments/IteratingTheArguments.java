/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratingthearguments;

/**
 *
 * @author dub10_000
 */
public class IteratingTheArguments {

    /**
     * Takes the strings from the command prompt and prints them each out 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int i=0; i<args.length; i++){
            System.out.println(args[i]);
        }
    }
    
}
