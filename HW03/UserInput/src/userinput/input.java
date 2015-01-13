/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinput;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *Gets integers from user and makes sure they are integers using exceptions
 * @author dub10_000
 */
public class input {
    private ArrayList<Integer> ints=new ArrayList();
    Scanner scan =new Scanner(System.in);
    /**
     * User inputs integers and catches exceptions
     * @param n the amount of integers used
     * @return  an arraylist of 10 integers all inputed by the user
     */
    public ArrayList<Integer> getInts(int n){
        System.out.printf("Enter %d integers:",(int)n);
        
        for(int i=0;i<n;i++){
            try{
                ints.add(scan.nextInt());
            }catch(Exception e){
                System.out.print("Not an int. Enter another: ");
                scan.nextLine();
                i--;
            }
        }
        return ints;
    }
}
