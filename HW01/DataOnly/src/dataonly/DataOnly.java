/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataonly;

/**
 *
 * @author dub10_000
 */
public class DataOnly {
   //creates each variable inside of DataOnly
   int i;//new int
   float f;//new float
   boolean b;//new boolean
   //PT: I'd rather you had two classes, one for main and the other for DataOnly
    public static void main(String[] args) {
        // TODO code application logic here
        DataOnly d = new DataOnly();//Creates a new DataOnly
        //Sets all of the values in DataOnly to certain values
        d.i=5;//sets the int to 5
        d.f=3;//sets the float to 3
        d.b=false;//sets the boolean to false
        System.out.printf("The int is %d The float is %f the boolean is %b" ,(int)d.i,(float)d.f,d.b);//prints each of the values inside of DataOnly 
    }
    
}
