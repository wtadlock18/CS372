/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager;
import java.util.*;
/**
 *
 * @author dub10_000
 */
public class Event {
    
    private String location, name, month, day, year, date;
    public Event(String date,String location,String name) throws IllegalArgumentException{
        //if(year<=0||day<=0||month<=0){
            
        //}
        this.name=name;
        this.location=location;
        year=date.substring(0,4);
        month=date.substring(4,6);
        day=date.substring(6,8);
        this.date=date;
    }
    @Override
    public String toString(){
        return "Name:"+name+" Location:"+location+" Month:"+month+" Day:"+day+" Year:"+year;
    }
    public String getName(){
        return name;
    }
    public String getLocation(){
        return location;
    }
    public String getDate(){
        return date;
    }
    public static Comparator<Event> NameComparator=new Comparator<Event>(){
        @Override
        public int compare(Event e1, Event e2){
            int cmp=e1.getName().compareTo(e2.getName());
            if(cmp==0)
                cmp=e1.getDate().compareTo(e2.getDate());
            if(cmp==0)
                cmp=e1.getLocation().compareTo(e2.getLocation());
            return cmp;
        }
    };
     public static Comparator<Event> DateComparator=new Comparator<Event>(){
        @Override
        public int compare(Event e1, Event e2){
            int  cmp=e1.getDate().compareTo(e2.getDate());
            if(cmp==0)
               cmp=e1.getName().compareTo(e2.getName());
            if(cmp==0)
                cmp=e1.getLocation().compareTo(e2.getLocation());
            return cmp;
        }
    };
     
      public static Comparator<Event> LocationComparator=new Comparator<Event>(){
        @Override
        public int compare(Event e1, Event e2){
            int  cmp=e1.getLocation().compareTo(e2.getLocation());
            if(cmp==0)
               cmp=e1.getName().compareTo(e2.getName());
            if(cmp==0)
                cmp=e1.getDate().compareTo(e2.getDate());
            return cmp;
        }
    };
}
