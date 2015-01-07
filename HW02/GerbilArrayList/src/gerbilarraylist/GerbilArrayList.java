/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerbilarraylist;
import java.util.*;

/**
 *Creates an ArrayList of Gerbils and calls the hop method in each
 * @author dub10_000
 */
public class GerbilArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List list=new ArrayList();
        for(int i=0;i<25;i++){
            list.add(new Gerbil(i));//adds a bunch of Gerbils to the list
        }
        //problem 2 using an iterator
        Iterator i=list.iterator();
        while(i.hasNext()){
            ((Gerbil)i.next()).hop();
        }
        /*problem 1
        for(int i=0;i<list.size();i++){
            Gerbil guy=(Gerbil)list.get(i);
            guy.hop();
        }*/
    }
    
}
