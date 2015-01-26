/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinput;
import java.util.*;
/**
 *Gets integers from the user and gives min, max, and average
 * @author dub10_000
 */
public class UserInput {

    /**
     * Gets a new array list which gets user input, and then prints min, max, and average
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> ints=new input().getInts(10);
        //PT -- stuff?
        calculates stuff=new calculates(ints);
        System.out.printf("Minimun Value is %d \n",(int)stuff.getMin());
        System.out.printf("Maximun Value is %d \n",(int)stuff.getMax());
        System.out.printf("Average Value is %f \n",stuff.getAvg());
        
    }
    
}
