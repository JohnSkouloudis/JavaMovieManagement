/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it2021091;

import static it2021091.It2021091.activeUser;
import static it2021091.It2021091.personsList;
import static it2021091.It2021091.showsList;
import static it2021091.It2021091.usersList;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author John skoul
 */
public class Account {

    
    protected String username;
    protected String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
   
    public void signInUser(User user){       
        activeUser=user;
    }
    
    public  static void signOutUser(){
        activeUser=null;
    }
    
    public void registerUser(String username,String password,String email){
        User user = new User(username,password,email);
        usersList.add(user);
        System.out.println(user.toString());
    }
    
    public ArrayList<Show> searchShows(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title or firstYear to search a show:");
        String search=input.nextLine();
        
        ArrayList<Show> results= new ArrayList<>();
        
        //βρίσκω τα αποτελεσματα που ταιριάζουν με αυτό που αναζητώ
        for (Show show : showsList) {
            if (show.getTitle().equalsIgnoreCase( search ) || Integer.toString( show.getFirstYear() ).equalsIgnoreCase( search ) ) {
                results.add(show);
            }
        }
        
        return results;   
    }
    
   public Person searchPerson(){
       Scanner input=new Scanner(System.in);
       System.out.println("Enter the fullName of an actor/director:");
        String fullName=input.nextLine();
        
        
        if( personExists( fullName) ){
            return returnPerson(fullName);
        }else{
            return null;
        }    
   } 
    
   
   public  ArrayList<Show> searchShowsWithPerson(Person person){
       
       
       ArrayList<Show> results= new ArrayList<>();
       
       for(Show show:showsList){
           if( show.getDirector().getFullName().equalsIgnoreCase( person.getFullName() ) ){
               results.add(show);
           }else{
               for(Person actor:show.getActors()){
                   if( actor.getFullName().equalsIgnoreCase( person.getFullName() ) ){
                       results.add(show);
                   }
               }
           }
       }
       
       return results;
   }
   
   public Show getHighestRatedShow(ArrayList<Show> results){
       
       Show highest = null;
        double highestRating =0.0;

        for (Show show : results) {
            double averageRating = show.getAvgRating();
            
            if (averageRating > highestRating) {
                highestRating = averageRating;
                highest = show;
            }
        }

        return highest;
    }
   
   
   public Show getLowestRatedShow(ArrayList<Show> results){
       
       Show lowest = null;
        double lowestRating =10.0;

        for (Show show : results) {
            double averageRating = show.getAvgRating();
            if (averageRating < lowestRating) {
                lowestRating = averageRating;
                lowest = show;
            }
        }

        return lowest;
    }
   
    
    public  User findUser(String email,String password){
        for(User u:usersList){
            if(u.getEmail().equalsIgnoreCase(email) && u.getPassword().equalsIgnoreCase(password)){
                return u;
            }
        }
        
        return null;
    }
    
    public void viewResultRatings(ArrayList<Show> results){
        
        for(Show show:results){
            System.out.println("Show " + show.getTitle() + " Ratings:");
            for(User user:usersList){
                
                for(Rating rating:user.getUserRatings() ){
                
                    if(rating.getShow().getTitle().equalsIgnoreCase( show.getTitle() ) ){
                    
                        System.out.println("User:"+ user.getUsername() +" Rating:" + rating.getGrade());
                    }
                        
                }   
                    
            }
            
        }
        
    }
    
    
    
    public boolean userExists(String username){
        for (User user :usersList ) {
            if (user.getUsername().equalsIgnoreCase(username)  ) {                
                return true;
            }
        }
        return false;
    }
    
    public boolean personExists(String personName){        
        for (Person person :personsList ) {
            if (person.getFullName().equalsIgnoreCase(personName)  ) {                
                return true;
            }
        }
        return false;    
      }
    
    
    public boolean ShowExists(String title){
        for (Show show : showsList) {
        if (show.getTitle().equalsIgnoreCase(title)) {
            return true;
        }
        else{   
        try {
            int id = Integer.parseInt(title);
            if (show.getId() == id) {
                return true;
            }
        } catch (NumberFormatException e) {
            
        }
       } 
    }
    return false;
        
    }
    
     
    
    public Person returnPerson(String personName){
        
        for (Person p :personsList ) {
            if (p.getFullName().equalsIgnoreCase(personName)) {
                return p;               
            }
        }         
        return null;
    }
    
        
    
    public Show returnShow(String title) {
    for (Show s : showsList) {
        try {
            if (s.getTitle().equalsIgnoreCase(title) || s.getId() == Integer.parseInt(title)) {
                return s;
            }
        } catch (NumberFormatException e) {
           
        }
    }
    return null;
}
    
        
    
    
    
    
}
