/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cookiesales;
import java.util.ArrayList;
import java.util.List;
/**
 *The store holds all of the cookies sold and the total money raised
 * @author wtadlock18
 */
public class Store {
    //private List<Cookie> storage=new ArrayList();
    private List<Cookie> sold=new ArrayList();
    private int ThinMints;
    private int Samoas;
    private int Tagalongs;
    
    /*public Store(){
        for(int i=0;i<25;i++){
            storage.add(new Cookie(1));
            storage.add(new Cookie(2));
            storage.add(new Cookie(3));
        }
    }*/
    /**
     * Buys some cookies and adds them to the sold list
     * @param type The type of cookie. 1 for Thin Mint, 2 for Samoa, 3 for Tagalong
     * @param amount The amount of cookies purchased
     */
    public void buy(int type,int amount){//type 1 for Thin Mints, 2 for Samoa, and 3 for Tagalong
        for(int i=0;i<amount;i++){
            Cookie c=new Cookie(type);
        //if(storage.contains(c)){
            //storage.remove(c);
            sold.add(c);
            //
            if(type==1){
                ThinMints++;
            }
            if(type==2){
                Samoas++;
            }
            if(type==3){
                Tagalongs++;
            }
               
        //}
        //else{
          //  return "Sorry, out of stock";
        //}
        } 
        //return "Sold. Enjoy your";
    }
    /**
     * Finds out how many cookies there are of a certain type
     * @param type Type of cookie. 1 for Thin Mint, 2 for Samoa, 3 for Tagalong
     * @return the amount of cookies of the provided type
     */
    public int getAmountOf(int type){
        //returns the amount of each type of cookie
        if(type==1){
            return ThinMints;
        }
        if(type==2){
            return Samoas;
        }
        if(type==3){
            return Tagalongs;
        }
        return 0;
    }
    /**
     * Gets the total money raised from the total sold cookies
     * @return the total money raised
     */
    public int getRevenue(){
        //Goes through all sold cookies and adds all the prices together
        int totalPrice=0;
        for(int i=0;i<sold.size();i++){
            totalPrice+=sold.get(i).getPrice();
        }
        return totalPrice;
    }

    
}
