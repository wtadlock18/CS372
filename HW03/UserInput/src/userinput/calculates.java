/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinput;
import java.util.ArrayList;
/**
 *Calculates the minimum, maximum, and average values in an arraylist of integers
 * @author dub10_000
 */
public class calculates {
    int max=0;
    int min=0;
    double avg=0;
    /**
     * Messy constructor, but YOLO
     * @param ints the array which we use to find min, max, and average
     */
    public calculates(ArrayList<Integer> ints){
        for(int i=0;i<ints.size();i++){
            int n=ints.get(i);
            avg+=n;
            if(i==0){
                max=n;
                min=n;
            }else{
                if(max<n){
                    max=n;
                }
                if(min>n){
                    min=n;
                }
            }
            
        }
        avg/=ints.size();
    }
    /**
     * Gets minimum value
     * @return  Minimum value
     */
    public int getMin(){
        return min;
    }
    /**
     * Gets Maximum value
     * @return Maximum value
     */
    public int getMax(){
        return max;
    }
    /**
     * Gets Average Value
     * @return Average Value
     */
    public double getAvg(){
        return avg;
    }

}
