/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package underover;
import java.util.Random;
/**
 *This is where the dice is rolled
 * @author dub10_000
 */
public class DiceRoll {
    private int first,second,sum;
    /**
     * Rolls the dice
     */    
    public DiceRoll(){
        Random rnd=new Random();
        first=rnd.nextInt(6)+1;
        second=rnd.nextInt(6)+1;
        sum=first+second;
    }
    /**
     * Gets the sum of the dice
     * @return the sum of the dice
     */
    public int getSum(){
        return sum;
    }
    /**
     * Gets the value of the first die
     * @return the value of the first
     */
    public int getFirst(){
        return first;
    }
    /**
     * Gets the value of the second die
     * @return the value of second first
     */
    public int getSecond(){
        return second;
    }
}
