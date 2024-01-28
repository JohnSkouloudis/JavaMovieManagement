/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it2021091;

import static it2021091.It2021091.personsList;
import static it2021091.It2021091.showsList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author John skoul
 */
public class Admin extends Account {

    public Admin(String username, String password) {
        super(username, password);
    }
       
    //καταχωρηση θεαματος η σειρας
    public void addShow(){
        
        Scanner input=new Scanner(System.in);
        /*εισάγω τίτλο θεάματος*/
        System.out.print("Title: ");       
        String title = input.nextLine();
        
        //αν είναι ήδη καταχωρημενο 
        if(super.ShowExists(title)){
            System.out.println("This Show already exists");
            return;
        }
        
        
        
        /*εισάγω έτος 1ης προβολής*/
        System.out.print("Year: ");
        int year=input.nextInt();
        
        input.nextLine();
        
        /*εισάγω χώρα παραγωγής*/
        System.out.print("Country: ");
        String country=input.nextLine();
        
        
        /*εισάγω τύπο θεάματος*/
        System.out.print("type or types: ");
        String types=input.nextLine();
        
        String[] arraytypes = types.split(" ");
        
        ArrayList<String> typelist = new ArrayList<>();        
        for (String str : arraytypes) {
            typelist.add(str.trim()); 
        }
        System.out.println("types:" + typelist);
        
        /*εισάγω σκηνοθέτη*/
        System.out.println("Director details:");
        System.out.print("Director fullname:");
        String directorName=input.nextLine();
        
        Person director;
        
        if( super.personExists(directorName) ){
           System.out.println("this Director already exists in the system");
            director=  super.returnPerson(directorName);
            
            System.out.println(director.toString());
        } else {
            //εισαγωγη ημερομηνια γεννησης σκηνοθέτη
            System.out.print("Director birthdate(enter day/month/year with space between them):");
            String directorBirthdate=input.nextLine();
            String addslashBirthdate = directorBirthdate.replaceAll("\\s+", "/");
            System.out.println("Formatted birthdate: " + addslashBirthdate);
            
            //εισαγωγη χωρα καταγωγής σκηνοθέτη
            System.out.print("Director country:");
            String directorCountry=input.nextLine();
            
            
            //εισαγωγη ιστοσελιδα σκηνοθέτη
            System.out.print("Director website:");
            String directorWebsite=input.nextLine();
             
             director= new Person(directorName,addslashBirthdate,directorCountry,directorWebsite);
             System.out.print(director.toString());
            
            personsList.add(director);          
        }
        
        //εισαγωγη ηθοποιών
        System.out.print("enter number of actors you want to add:");
        int numberOfactors=input.nextInt();
        
        input.nextLine();
        
        ArrayList<Person> actors=new ArrayList<>();
        
        for(int i=0; i<numberOfactors; i++){
            
            Person actor;
               
            //εισαγωγη ονόματος
            System.out.print("enter actor fullName:");
            String actorName=input.nextLine();
            
            if( super.personExists(actorName) ){
                System.out.println("this Actor already exists in the system");
                actor=  super.returnPerson(actorName); 
                System.out.println( actor.toString() );
                
                actors.add(actor);
            }else{
                
                //εισαγωγη ημερομηνιας γεννησης ηθοποιού
                System.out.print("enter actor birthdate(enter day/month/year with space between them):");
                String actorBirthdate=input.nextLine();
                String addslashBirthdate = actorBirthdate.replaceAll("\\s+", "/");
                System.out.println("Formatted birthdate: " + addslashBirthdate);
                
                //εισαγωγη χώρας ηθοποιού
                System.out.print("enter actor country:");
                String actorCountry=input.nextLine();
                
                //εισαγωγη ιστοσελιδας ηθοποιου
                System.out.print("enter actor website:");
                String actorWebsite=input.nextLine();
                
                //δημιουργω τον ηθοποιό
                actor= new Person(actorName,addslashBirthdate,actorCountry,actorWebsite);
                System.out.println(actor.toString());
                
                
                actors.add(actor);
                
                personsList.add(actor);
            }
            
        }
        
        System.out.println("is the show a series?(y/n)");
        char answer=input.nextLine().charAt(0);
        
        if( (answer=='Y') || (answer=='y') ){
            
            System.out.println("enter the number of seasons:");
            int seasons=input.nextInt();
            
            //εισαγωγή επεισόδια ανα σεασόν
            int[] episodesPerSeason= new int[seasons];
            
            for(int i=0; i<seasons; i++){
                
            System.out.print("episodes of season " +  (i+1) + ":" );
            episodesPerSeason[i]=input.nextInt();
            
            }
            
            input.nextLine();
            
            //εισαγωγή έτους τελευταίας προβολής
            System.out.println("enter series last year(leave it blank if the series is still running):");
            String lastYear=input.nextLine();
            
            Series series= new Series(seasons,episodesPerSeason,lastYear,title,year,typelist,country,director,actors);
            System.out.println(series.toString());
            
            showsList.add(series);
            
            System.out.println("series added Successfully!!!");
            
        }else {
            
            Show show=new Show(title,year,country,director,typelist,actors);
            System.out.println(show.toString());
            
            showsList.add(show);
            
            System.out.println("Show added Successfully!!!");
            
        }
        
        
        
        
    }

    public void updateSeries(){
    
        System.out.print("provide the serie's id or title that you are searching:");
        Scanner input= new Scanner(System.in);
        
        String search=input.nextLine();
        
        if(!super.ShowExists(search)){
         
            System.out.println("This Show doesnt exist");
            
        }else if(super.returnShow(search) instanceof Series){
            
                Series series = (Series) super.returnShow(search);
                System.out.println("Series title:" + series.getTitle());
                
                System.out.println("""
                            Choose what you want to change:                            
                            1. number of seasons
                            2. number of episodes of a season
                            3. last year
                            4. add actor to the series
                             """);
            
                
                int choice=input.nextInt();
                switch(choice){
                    case 1:
                        int previousSeasons=series.getSeasons();
                        int[]previousEpisodesPerSeason=series.getEpisodesPerSeason();
                        
                      System.out.print("enter new number of seasons:");
                      int updatedSeasons=input.nextInt(); 
                      
                      
                      int[]updatedEpisodesPerSeason=Arrays.copyOf(previousEpisodesPerSeason, updatedSeasons);
                      
                      series.setSeasons(updatedSeasons);
                      series.setEpisodesPerSeason(updatedEpisodesPerSeason); 
                      
                      if(updatedSeasons > previousSeasons){
                          System.out.println("enter the episodes for the new seasons.");
                          
                          for(int i=1; i<=(updatedSeasons - previousSeasons); i++){
                              
                             System.out.print("enter the episodes for season " + (previousSeasons + i) +":");
                             int episodes=input.nextInt();
                             
                             series.setEpisodesForSeason(previousSeasons + i, episodes);
                             
                          }                          
                      }
                      System.out.println( "New number of seasons is:"+series.getSeasons() );
                      System.out.println(Arrays.toString(series.getEpisodesPerSeason()) );
                      
                      
                      for(int i=1; i<=series.getSeasons(); i++){
                          System.out.println("Season:" + i +" episodes:" + series.getEpisodesForSeason(i) );
                      }
                      
                        break;
                    case 2:
                        
                        System.out.print("enter a season out of " +  series.getSeasons() +":");
                        int season=input.nextInt();
                        
                        if( season<=0 || season>series.getSeasons() ){
                            System.out.println("wrong input");
                            
                        }else{
                            
                           System.out.println("enter number of episodes for season " + season +":");
                           int episodes=input.nextInt();
                           
                           if(episodes<=0){
                               System.out.println("wrong input");
                           }else{
                               series.setEpisodesForSeason(season, episodes);
                           }
                           
                           for(int i=1; i<=series.getSeasons(); i++){
                                System.out.println("Season:" + i +" episodes:" + series.getEpisodesForSeason(i) );
                            }
                           
                        }
                        
                        break;
                    case 3:
                        
                        System.out.print("enter last year:");
                        input.nextLine();
                        String lastYear=input.nextLine();
                        
                        try{
                            
                        if(lastYear.equalsIgnoreCase("-")){
                            
                            series.setLastYear("-");
                            
                        }else if(Integer.parseInt(lastYear)<=0){
                            
                            System.out.println("wrong input");
                            
                        }else{                           
                            series.setLastYear(lastYear);                           
                        }
                        
                        }catch(NumberFormatException e){
                            System.out.println("wrong input");
                        }
                        
                        
                        break;
                    case 4:
                        
                        System.out.print("enter actor fullname:");
                        
                        input.nextLine();
                        
                        String actorName=input.nextLine();
                        
                        
                        
                        for( Person p:series.getActors() ){
                            if(p.getFullName().equalsIgnoreCase(actorName)){
                                System.out.println("this Actor is already added to this series!");
                                return;
                            }
                        }
                        
                        Person actor;
                        
                        if( super.personExists(actorName) ){
                            System.out.println("this Actor already exists in the system");
                            actor=  super.returnPerson(actorName); 
                            System.out.println( actor.toString() );
                            series.addActor(actor); 
                            
                            System.out.println(actor.getFullName() + " was added to the actors of this series!");
                            System.out.println(series.getActors());
                        }else{
                            //εισαγωγη ημερομηνιας γεννησης ηθοποιού
                            System.out.print("enter actor birthdate(enter day/month/year with space between them):");
                            String actorBirthdate=input.nextLine();
                            String addslashBirthdate = actorBirthdate.replaceAll("\\s+", "/");
                            System.out.println("Formatted birthdate: " + addslashBirthdate);
                
                            //εισαγωγη χώρας ηθοποιού
                            System.out.print("enter actor country:");
                            String actorCountry=input.nextLine();
                            
                
                            //εισαγωγη ιστοσελιδας ηθοποιου
                            System.out.print("enter actor website:");
                            String actorWebsite=input.nextLine();
                            
                
                            //δημιουργω τον ηθοποιό
                            actor= new Person(actorName,addslashBirthdate,actorCountry,actorWebsite);
                            System.out.println( actor.toString() );
                            
                            series.addActor(actor);
                            
                            System.out.println(actor.getFullName() + " was added to the actors of this series and to the system!");
                            System.out.println(series.getActors());
                            
                            personsList.add(actor);
                        }
                        
                        break;
                    default:
                        System.out.println("This option was not found.");
                        break;
                                
                }
                
               
        
        }else{
           System.out.println("This is a show not a series"); 
        }
            
        
        
        
        
    }
    
    
    
    

    
    
    
    
}
