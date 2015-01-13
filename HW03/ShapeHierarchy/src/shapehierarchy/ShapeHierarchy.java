/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapehierarchy;
import java.util.ArrayList;
/**
 *Just makes sure the code works. Serves no real purpose in the context of the assignment
 * @author dub10_000
 */
public class ShapeHierarchy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Shape> shapes=new ArrayList();
        try{
            shapes.add(new Triangle(1,2,2));
            shapes.add(new Ellipse(2,2));            
            shapes.add(new Rectangle(5,25));
            
            for(Shape s:shapes){
            System.out.printf("The area of this %s is %f and the Perimeter is %f\n",s, s.getArea(), s.getPerimeter());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
