/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapehierarchy;

/**
 *A ellipse that lets you get the area and perimeter and makes sure the side lengths are greater than Zero
 * @author dub10_000
 */
public class Ellipse extends Shape{
    int r1,r2;
    /**
     * Constructs an Ellipse and tries to calculate the area and the perimeter
     * @param r1 first radius
     * @param r2 second radius
     * @throws IllegalArgumentException if the radii aren't greater than Zero 
     */
    public Ellipse(int r1,int r2) throws IllegalArgumentException{
        if(r1<=0||r2<=0){
            throw new IllegalArgumentException("The radii need to be larger than 0");
        }
        this.r1=r1;
        this.r2=r2;
        
        
    }
    /**
     * Updates the toString function
     * @return  the type of shape this is
     */
    public String toString(){
        return "Ellipse";
    }
    @Override
    /**
     * Gets the area of the Ellipse
     */
    public double getArea(){
        return (double)Math.PI*r1*r2;
    }
    @Override
    /**
     * gets the perimeter of the Ellipse
     */
    public double getPerimeter(){
        return 2* Math.PI* Math.sqrt((double)(r1*r1+r2*r2)/2); 
    }
}
