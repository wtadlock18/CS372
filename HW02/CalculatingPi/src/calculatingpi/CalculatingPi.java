/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatingpi;

/**
 *Calculates pi either from the command prompt or from the program
 * @author dub10_000
 */
public class CalculatingPi {

    /**
     * Calculates pi
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pi pi=new Pi();
        if(args.length>0){
            pi.Calculate(Integer.parseInt(args[0]));
        }else{
            pi.Calculate(200000);
        }
        pi.DisplayPi();
    }
    
}
