/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cookiesales;

/**
 *The cookie that is bought
 * @author dub10_000
 */
public class Cookie {
    
    private int price;
    /**
     * Creates the cookie and the price of the cookie
     * @param type The type of Cookie. 1 for Thin Mint, 2 for Samoa, 3 for Tagalong 
     */
    public Cookie(int type){
        price=type+2;
    }
    /**
     * Gets the price of the cookie
     * @return the price of the cookie
     */
    public int getPrice(){
        return price;
    }
}
