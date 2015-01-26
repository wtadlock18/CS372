/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapehierarchy;

/**
 *A rectangle that lets you get the area and perimeter and makes sure the side lengths are greater than Zero
 * @author dub10_000
 */
public class Rectangle extends Shape{
    int width,length;
    /**
     * Constructs a rectangle with given length and width
     * @param width the width of the rectangle
     * @param length the length of the rectangle
     * @throws IllegalArgumentException Makes sure the length and width are greater than Zero
     */
    public Rectangle(int width,int length)throws IllegalArgumentException{
        if(width<=0||length<=0){
            throw new IllegalArgumentException("Shapes sides need to be longer than 0");
        }
        this.width=width;
        this.length=length;
    }
     /**
     * Updates the toString function
     * @return  the type of shape this is
     */
    public String toString(){
        //PT -- good, but make it more informative:
        // return String.format("Rectangle (%f X %f)", width, length);
        return "Rectangle";
    }
    @Override
    /**
     * Gets the area of the rectangle
     */
    public double getArea(){
        return (double)length*width;
    }
    @Override
    /**
     * Gets the area of the rectangle
     */
    public double getPerimeter(){
        return (double)(2*length)+(2*width);
    }
}
