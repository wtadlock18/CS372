/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumbers;
import java.util.Scanner;
/**
 *
 * @author dub10_000
 */
public class PrimeNumbers {

    /**
     * Finds all prime numbers within a range provided by the user
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the range to find prime numbers");//has the user input the range to check prime numbers
        System.out.print("First Number:");
        int first=input.nextInt();
        System.out.print("Last Number:");
        int last=input.nextInt();
        System.out.printf("\nThese are all of the prime numbers from %d to %d\n",(int)first,(int)last);
        for(int i=first;i<=last;i++){//checks values from 1 to 100
            boolean isPrime=true;//makes something to check if a prime number was found
            for(int j=2;j<i;j++){//goes from 1 to the current value
               if(i%j==0){
                   isPrime=false;
               }
            }
            if(isPrime){//if it was found to be a prime number it prints the number
                System.out.println(i);
            }
        }
    }
    
}
