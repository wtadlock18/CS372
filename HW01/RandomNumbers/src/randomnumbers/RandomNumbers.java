/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomnumbers;
import java.util.*;
/**
 *
 * @author dub10_000
 */
public class RandomNumbers {

    /**
     * Generates 25 sets of two numbers and prints both numbers and states the relationship between the two numbers
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random rand =new Random();//Creates the Random Number Generator
        for(int i=0;i<25;i++){//iterates the random numbers 25 times
            int first=rand.nextInt(125);//gets the first random number
            int second=rand.nextInt(125);//gets the second random number
            if(first<second){//Checks if the first is less than the second
                System.out.printf("%d is less than %d\n",(int)first,(int)second);
            }else if(first>second){//checks id the first is greater than the second
                 System.out.printf("%d is greater than than %d\n",(int)first,(int)second);
            }else if(first==second){//checks if both are equal
                 System.out.printf("%d is the same as %d\n",(int)first,(int)second);
            }
            
        }
        
    }
    
}
