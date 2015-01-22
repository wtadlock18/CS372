/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantreviewer;

/**
 *
 * @author dub10_000
 */
public class Restaurant {
    private String name, location;
    
    public Restaurant(String n, String l){
        name= n;
        location=l;
    }
    public Restaurant(){
        
    }
    public String getName(){
        return name;
        
    }
    public String getLocation(){
        return location;
    }
    public void setName(String n){
        name=n;
        
    }
    public void setLocation(String l){
       location=l;
    }
}
