/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it2021091;

import static it2021091.It2021091.showsId;
import static it2021091.It2021091.usersList;
import java.util.ArrayList;

/**
 *
 * @author John skoul
 */
public class Show {
    
        protected int id;
        protected String title;
        protected int firstYear;
        protected String country;
        protected Person director;
        protected ArrayList<String> types;
        protected ArrayList<Person> actors;
        protected double avgRating;
        
        
    public Show(String title, int firstYear,  String country, Person director){
        this.id = showsId;
        showsId++;
        
        this.title = title;
        this.firstYear = firstYear;
        this.types = new ArrayList<>();
        this.country = country;
        this.director = director;
        this.actors = new ArrayList<>();
        
        this.avgRating=0;
        
        
    }

    public Show( String title, int firstYear,  String country, Person director, ArrayList<String> types,ArrayList<Person> actors ) {
        this.id = showsId;
        showsId++;
        
        this.title = title;
        this.firstYear = firstYear;
        this.types = types;
        this.country = country;
        this.director = director;
        this.actors = actors;
        
        this.avgRating=0;
        
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFirstYear(int firstYear) {
        this.firstYear = firstYear;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDirector(Person director) {
        
        this.director =  director;
    }

    public void setActors(ArrayList<Person> actors) {
        this.actors = actors;
    }

    public void setAvgRating() {
        this.avgRating=0;
        int usersCount=0;
        for(User u:usersList){
            for(Rating r:u.getUserRatings()){
                if(r.getShow().getTitle().equalsIgnoreCase(this.title)){
                   usersCount++; 
                   this.avgRating+=r.getGrade();
                   break;
                }
            }
        }
        
        if( usersCount != 0){
        this.avgRating = (this.avgRating)/usersCount;
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getFirstYear() {
        return firstYear;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public String getCountry() {
        return country;
    }

    public Person getDirector() {
        return director;
    }

    public ArrayList<Person> getActors() {
        return actors;
    }
    
    public void addActor(Person actor){
            this.actors.add( actor);
            
    }
    
    public void addType(String type){
             this.types.add(type);
            
    }

    public double getAvgRating() {
        setAvgRating();
        return avgRating;
    }
    
    

    @Override
    public String toString() {
        return "Show:{" + "\n" +
                "id=" + id + " , "+
                "title=" + title + " , "+
                "firstYear=" + firstYear + " , "+
                "types=" + types + " , "+
                "country=" + country + " , "+
                "director=" + director.getFullName() + " , " +
                "actors=" + actors.toString() +"}"+ "\n";
    }

    
    
    
        
        
        
}
