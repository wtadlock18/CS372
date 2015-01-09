/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areaofcircle;
import java.util.Scanner;
/**
 *
 * @author dub10_000
 */
public class AreaOfCircle {

    /**
     * Prompts user for the Radius of the circle, calculates the area, and then outputs the area
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the Radius of your circle?");//asks user what the radius is
        final double PI=3.14;//creates PI, it is delicious
        //PT: the built-in java.lang.Math.PI is more delicious.
        int r=input.nextInt();//gets the radius of the circle from the user
        double Area=PI*r*r;//calculates Area
        System.out.printf("The Area of the circle with radius %d is %f",(int)r,(double)Area);//Displays Area
    }
    
}
