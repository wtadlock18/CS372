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
public class Review {
   private Restaurant r;
   
   private String review, name,location;
   private int star;
   public Review(Restaurant rest, String rev, int s){
       r=rest;
       review=rev;
       name=rest.getName();
       star=s;
       location=rest.getLocation();
   }
   public Review(){
        
    }
   public String getLoc(){
       return location;
   }
   @Override
   public String toString(){
       return String.format(" Restaurant: %s \n Location: %s \n Star Rating: %d \n Review: %s \n ", name, r.getLocation(), star,review);
   }
}
