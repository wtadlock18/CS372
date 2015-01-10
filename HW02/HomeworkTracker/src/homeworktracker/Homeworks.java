/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworktracker;
import java.util.ArrayList;
import java.util.List;
/**
 *Holds homework and enters new homework scores
 * @author wtadlock18
 */
public class Homeworks {
    List<Integer> scores=new ArrayList();
    /**
     * Adds a new score to the homework arraylist
     * @param score The new score that is entered
     */
    public void addScore(int score){
        scores.add(score);
    }
    /**
     * Gets the maximum score
     * @return The maximum score entered
     */
    public int getMax(){
        int max=0;
        for(int i=0;i<scores.size();i++){
            if(scores.get(i)>max){
                max=scores.get(i);
            }
        }
        return max;
    }
    /**
     * Gets the minimum score
     * @return The minimum score entered
     */
    public int getMin(){
        int min=100;
        for(int i=0;i<scores.size();i++){
            if(scores.get(i)<min){
                min=scores.get(i);
            }
        }
        return min;   
    }
    /**
     * Calculates and gets the average score
     * @return The average score entered
     */
    public double getAvg(){
        double Avg=0;
        for(int i=0;i<scores.size();i++){
            Avg+=(double)scores.get(i);
        }
        Avg/=scores.size();
        return Avg;
    }
    /**
     * How many scores
     * @return the number of scores entered
     */
    public int getNum(){
        return scores.size();
    }
}
