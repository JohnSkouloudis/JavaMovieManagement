/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it2021091;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author John skoul
 */
public class User extends Account {
    
    private String email;
    private ArrayList<Person> favourites;
    private ArrayList<Rating> userRatings;

    public User(String username , String password, String email ) {
        super(username, password);
        this.email = email;
        
        this.favourites= new ArrayList<>();
        this.userRatings= new ArrayList<>();
        
    }

    public void viewUserRatings(){
        System.out.println("User:"+ this.username +" ratings:");
        for( Rating rating:userRatings ){
             System.out.println("Show title:"+ rating.getShow().getTitle() + " rating:" + rating.getGrade() );
        }
    
    }
    
    public void rateShow(String title){
        
        Scanner input=new Scanner(System.in);
        
        if( super.ShowExists(title) ){ 
            Show show= super.returnShow(title);
            
            if( RatingExists(show.getTitle()) ){
                
                System.out.print("This Show has already been rated by this user.Would you like to change  it?:");
                String c=input.nextLine();
                
               
                if(c.equalsIgnoreCase("y")){
                    double newRating=0;
                    while( newRating<=0 || newRating>10 ){
                        
                    System.out.print("Enter a rating between 1-10:");
                    String ratingString = input.nextLine().replace(',','.');
                     newRating=Double.parseDouble(ratingString);
                     
                    
                    }
                    
                    Rating rate=returnRating(title);
                    rate.setGrade(newRating);
                    System.out.println("Rating has been changed!");
                  
                }
            }else{                
                double newRating=0;
                
                while(newRating<=0 || newRating>10){
                 System.out.print("rate the show "+ title +" from 1-10:");
                 String ratingString = input.nextLine().replace(',', '.');
                 newRating=Double.parseDouble(ratingString);
                 
                }
                
                addRating(show,newRating);
                System.out.println("Show rated successfully");
                    
                
            }
                
        }else{
            System.out.println("This show doesnt exist");
        }
        
    }
    
    public boolean RatingExists(String title){
        
        for(Rating r:userRatings){
            if( r.getShow().getTitle().equalsIgnoreCase(title) ){
                return true;
            }
        }
        
        return false;
    }
    
    
    public Rating returnRating(String title){
        for (Rating r :userRatings ) {
            if (r.getShow().getTitle().equalsIgnoreCase(title)) {
                return r;               
            }
        }         
        return null;
    }
    
    
    public void addRating(Show show,double grade){
        Rating rate=new Rating(show,grade);
        this.userRatings.add(rate);
    }
    
    public String addFavourite(Person person){
        for(Person p:favourites){
            if( p.getFullName().equalsIgnoreCase( person.getFullName() ) ){               
                return "Person "+ person.getFullName() + " already exists in your favourites list!" ;
            }
        }
        this.favourites.add(person);
        return person.getFullName() +" was added successfully to your list!";
    }
    
    public void viewFavourites(){
        System.out.println("Favourites:");
        for( Person p:favourites){
                                 
            System.out.println( p.getFullName() );
        }
    }
    
    public void setUserRatings(ArrayList<Rating> userRatings) {
        this.userRatings = userRatings;
    }
        
    public void setFavourites(ArrayList<Person> favourites) {
        this.favourites = favourites;
    }
   
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Person> getFavourites() {
        return favourites;
    }

    public ArrayList<Rating> getUserRatings() {
        return userRatings;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username +", password=" + password + ", email=" + email + '}';
    }
    
    
   
    
}
