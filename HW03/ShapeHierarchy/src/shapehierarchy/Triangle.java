/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapehierarchy;

/**
 *A triangle 
 * @author dub10_000
 */
public class Triangle extends Shape{
    private int s1,s2,s3;
    /**
     * Constructs a triangle while throwing exceptions
     * @param s1 side 1
     * @param s2 side 2
     * @param s3 side 3
     * @throws IllegalArgumentException makes sure all sides are greater than zero and that it side lengths follow rules of being a triangle 
     */
    public Triangle(int s1,int s2,int s3)throws IllegalArgumentException{
        if(s1<=0||s2<=0||s3<=0){
            throw new IllegalArgumentException("Shapes sides need to be longer than 0");
        }   
        if((s1+s2)<=s3||(s1+s3)<s2||(s2+s3)<=s1){
            throw new IllegalArgumentException("Illegal side lengths for Triangles");
        }
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
    }
    
     /**
     * Updates the toString function
     * @return  the type of shape this is
     */
    public String toString(){
        return "Triangle";
    }
    @Override
    /**
     * gets the perimeter of the Triangle
     */
    public double getPerimeter(){
        return (double)(s1+s2+s3)/2;
    }
    @Override
    /**
     * gets the area of the Triangle
     */
    public double getArea(){
        double p =this.getPerimeter();
        return Math.sqrt(p*(p-s1)*(p-s2)*(p-s3));
    }
}
