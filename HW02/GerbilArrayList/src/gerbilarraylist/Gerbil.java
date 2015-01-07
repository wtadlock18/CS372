/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerbilarraylist;

/**
 *The Gerbil class that gives a Gerbil a number and has it hop
 * @author dub10_000
 */
public class Gerbil {
    int gerbilNumber;
    /**
     * Delicious Gerbil
     * @param newNumber gives a number to the Gerbil when it is created 
     */
    public Gerbil(int newNumber){//Constructor that sets a value to gerbilNumber 
        gerbilNumber = newNumber;
    } 
    public void hop(){
        //prints the gerbil number and says it is hopping
        System.out.printf("I am Gerbil number %d and I am hopping\n",gerbilNumber);
    }
}
