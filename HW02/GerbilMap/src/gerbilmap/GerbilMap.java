/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerbilmap;
import gerbilarraylist.*;
import java.util.*;
/**
 *This class sets the Gerbils into a map and goes through the map and makes each of them hop
 * @author dub10_000
 */
public class GerbilMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creates an empty map with String as the key and Gerbil as value
        Map<String,Gerbil> gerbilMap=new HashMap<String,Gerbil>(10);
        //For loop goes 9 times to add to the map
        for(int i=1;i<9;i++){
            Gerbil g=new Gerbil(i);//creates a Gerbil
            String name="Gerbil"+i;//Creates an awesome name
            gerbilMap.put(name,g);//adds Gerbil to map with name as the key
        }
    
        Iterator it=gerbilMap.keySet().iterator();//Creates iterator to go through the map
        while(it.hasNext()){
            String name= it.next().toString();//sets the name from the iterator
            System.out.printf("%s ",name);//prints the name
            gerbilMap.get(name).hop();//has the Gerbil hop
        }
    }
    
}
