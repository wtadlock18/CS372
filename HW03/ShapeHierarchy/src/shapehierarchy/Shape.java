/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapehierarchy;

/**
 *The base class for a Shape which is inherited by Triangle, Rectangle, and Ellipse
 * @author dub10_000
 */
public class Shape {
    /**
     * Default area for shape
     * @return Zero since nobody cares about it and shouldn't use it
     */
    public double getArea() {return 0;} 
    /**
     * Default perimeter for shape
     * @return Zero since nobody cares about it and shouldn't use it
     */
    public double getPerimeter() {return 0;}
}
