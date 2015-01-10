/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatingpi;
import java.util.ArrayList;
        /**
 *Generates Pi using a formula for an infinite series, evaluating the series to a given term
 * @author dub10_000
 */
public class Pi {
    
    public ArrayList<Double> piList=new ArrayList();
        /**
         * Calculates pi using the formula to a given term
         * @param max The number of terms the series uses
         */
    public void Calculate(int max){
        int _max=max;
        boolean add=true;
        double pi=0;
        
        
        for(int i=1;i<=_max*2;i+=2){
            if(add){
                pi+=(double)(4.0/i);
                add=false;
            }else{
                pi-=(double)(4.0/i);
                add=true;
            }
           
            piList.add(pi);
        }
    }
    /**
     * Displays Pi
     */
    public void DisplayPi(){
        for(int i=0;i<piList.size();i++){
            System.out.printf("Term #%d:   %f \n", i+1,piList.get(i));
        }
    }
  /**
   * Gives what pi is after the final term in the series
   * @return The most accurate value of pi calculated in this series
   */
    public double getLast(){
        return piList.get(piList.size()-1);
    }
}
