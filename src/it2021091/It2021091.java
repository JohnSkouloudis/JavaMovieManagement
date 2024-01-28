/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package it2021091;


/*import static it2021091.Account.signOutUser;*/
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author John skoul
 */
public class It2021091 {
    
    public static int personId=0;
    public static int showsId=0;
    
    
    public static ArrayList<Show> showsList = new ArrayList<>();   
    public static ArrayList<Person> personsList = new ArrayList<>();
    public static ArrayList<User> usersList = new ArrayList<>();
    
    public static User activeUser=null; 
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
          Admin admin= new Admin("admin","admin");
          
          Data data= new Data();
        
        
        
        
        
      boolean loop=true; 
      Scanner input=new Scanner(System.in);
      
        while(loop){
            
            if(activeUser==null){
            System.out.println("------logged in as Guest------");
            }else{
            System.out.println("------logged in as User: "+ activeUser.getUsername() +"------");
            }
            
            System.out.println("""
                           Welcome to the JavaEntertainment app.Choose between option 0-5:
                            0.Exit the app
                            1.Register a new show
                            2.Update a series
                            3.Search and rate a show
                            4.Search and add a favourite actor/director
                            5.sign in or register a user 
                             """);
            
            int choice=input.nextInt();
            
            switch(choice){
                case 0:
                    System.out.println("exiting the app...");
                    loop=false;
                    break;
                //Καταχώρηση θεάματος    
                case 1:
                    admin.addShow();
                    break;
                //Ανανέωση θεάματος
                case 2:
                    admin.updateSeries();
                    break;
                //Αναζήτηση πληροφοριών και Αξιολόγηση    
                case 3:
                    
                    ArrayList<Show> results = admin.searchShows();
                    
                    if (results.isEmpty()) {
                    System.out.println("There where no results for this search.");
                    
                    }else{ 
                        
                        //εμφανισε τα στοιχεια των αποτελεσμάτων
                        System.out.printf("Found %d results:\n", results.size());
                        
                        for(Show show:results){ 
                            System.out.println("result: " + results.indexOf(show) );
                            System.out.println("ID: " +  show.getId() );
                            System.out.println("Title: " + show.getTitle() );
                            System.out.println("FirstYear: " +show.getFirstYear() );
                            System.out.println("Type: "+ show.getTypes());
                            System.out.println("Director: " + show.getDirector().getFullName() );
                            System.out.println("Average user rating: " + show.getAvgRating() );
            
                            if(show instanceof Series){
                                Series series = (Series) show;
                                System.out.println("lastYear: " + series.getLastYear());
                                System.out.println("Number of seasons: " + series.getSeasons());
                            }
                          }
                       
                        //αξιολογηση θεαματος απο τα αποτελεσματα
                        input.nextLine();
                        System.out.print("Do you want to rate a show from the results(y/n)?:"); 
                        String answer = input.nextLine();
                        
                         while(answer.equalsIgnoreCase("y")){
                        
                            if(activeUser==null){
                                System.out.print("You need to be signed in ");
                                System.out.print("Enter email: ");
                                String email=input.nextLine();
                                System.out.print("Enter password: ");
                                String password=input.nextLine();
                                
                                if( admin.findUser(email,password)!=null){
                                    admin.signInUser( admin.findUser( email , password ) );
                                }else{
                                System.out.print("This user doesnt exist.Do you want to register this user with email:" + email + " and password:"+ password +"(y/n)?:");
                                   String c=input.nextLine();
                                    if(c.equalsIgnoreCase("y")){
                                        System.out.print("enter username:");
                                        String username=input.nextLine();
                                        if( admin.userExists(username) ){
                                            System.out.println("this username already exists!Do you still want to rate a show from the results(y/n)?:");
                                            answer=input.nextLine();
                                        }else{
                                            admin.registerUser(username,password,email);
                                            User user=admin.findUser(email, password);
                                            admin.signInUser(user);
                                            System.out.print("Do you still want to rate a show from the results(y/n)?:");
                                            answer=input.nextLine();
                                            
                                        }
                                        
                                    }else{
                                        System.out.print("Do you still want to rate a show from the results(y/n)?:");
                                        answer=input.nextLine();
                                    }
                                    
                                 }
                                
                            }else{                                 
                                 for(Show show:results){
                                 System.out.println("result index: " + results.indexOf(show) + ", Show title:" + show.getTitle() );
                                 }
                                 
                                System.out.print("choose a show to rate by giving the index of the show from the results:");
                                int index=input.nextInt();
                                input.nextLine();
                                
                                String title=null;
                                for(Show show:results){
                                    if( index == results.indexOf(show) ){
                                         title=show.getTitle();
                                         break;
                                    }  
                                }
                                if(title!=null){
                                activeUser.rateShow(title);
                                answer="n";
                                }else{
                                    System.out.print("This index was not found.Do you want to give a different index(y/n)?: ");
                                    answer=input.nextLine();
                                }
                                
                            }
                            
                        }
                        
                        System.out.print("Do you want to view the ratings for each result?(y/n): ");
                        answer=input.nextLine();
                        if(answer.equalsIgnoreCase("y")){
                            admin.viewResultRatings(results); 
                        }
                        
                        if(activeUser!=null){
                            System.out.print("Do you want to view your own ratings?(y/n): ");
                            answer=input.nextLine();
                            if(answer.equalsIgnoreCase("y")){
                            activeUser.viewUserRatings();
                            }
                        }
                        
                  }
                    
                       
                    break;
                //Αναζήτηση πληροφοριών και Αγαπημένος ηθοποιός/ σκηνοθέτης
                case 4:
                    
                    Person searchedPerson=admin.searchPerson();
                    
                    input.nextLine();
                    
                    if(searchedPerson==null){
                        System.out.println("This person doesnt exist!");
                        
                    }else{
                        
                        System.out.println("id:" + searchedPerson.getId());
                        System.out.println("Name:" + searchedPerson.getFullName());
                        System.out.println("Shows:");                       
                                                 
                        ArrayList<Show> personResults=admin.searchShowsWithPerson(searchedPerson);  
                        
                        
                        
                        if(!personResults.isEmpty()) {
                            
                            for(Show show:personResults){
                               System.out.println( show.getTitle() ); 
                            }
                                
                                
                            
                            System.out.print("Do you want to see the highest and lowest average rating show that includes "+ searchedPerson.getFullName() +" ?(y/n):");
                            String answer=input.nextLine();
                            
                            if( answer.equalsIgnoreCase("y") ){
                                
                                Show highest=admin.getHighestRatedShow(personResults);
                                Show lowest=admin.getLowestRatedShow(personResults);    
                                System.out.println("highest  rated Show:"+ highest.getTitle()+" average rating:"+ highest.getAvgRating());
                                System.out.println("lowest  rated Show:"+ lowest.getTitle()+" average rating:"+ lowest.getAvgRating());
                            }
                            
                        }
                        
                        if(activeUser!=null){
                        
                            System.out.print("Do you want to add " + searchedPerson.getFullName() + " to your favourites(y/n)?:");
                            String answer=input.nextLine();
                            if( answer.equalsIgnoreCase("y") ){
                                System.out.println( activeUser.addFavourite(searchedPerson) ); 
                                
                            }
                        }
                        
                    } 
                    
                    if(activeUser!=null){
                        System.out.print("Do you want to view your list of favourite People(y/n)?:");
                        String answer=input.nextLine();
                         if( answer.equalsIgnoreCase("y") ){
                             
                             activeUser.viewFavourites();
                         }
                    }
                    
                    
                    break;
                case 5:
                    System.out.println("""
                                       choose an option:
                                       1.Sign in as a user
                                       2.Sign out
                                       3.Register a new User
                                       """);
                    
                    int c=input.nextInt();
                    switch(c){
                        case 1:
                            System.out.print("enter email:");
                            
                            input.nextLine();
                                    
                            
                            String email=input.nextLine();
                            
                            System.out.print("enter password:");
                            String password=input.nextLine();
                            
                            if(admin.findUser(email,password)==null){
                                System.out.println("This user is not registered!");
                            }else{
                                User RegisteredUser=admin.findUser(email,password);
                                admin.signInUser(RegisteredUser);
                                System.out.println("signed in as User:"+ RegisteredUser.getUsername());
                            }
                            
                            break;
                        case 2:
                            
                            Account.signOutUser();
                            
                            break;
                        case 3:
                            System.out.print("enter username:");
                            input.nextLine();
                            String username=input.nextLine();
                            
                            
                            
                            if(admin.userExists(username)){
                                System.out.println("This user already exists!");
                            }else{
                                System.out.print("enter email:");
                                String userEmail=input.nextLine();
                                
                                System.out.print("enter password:");
                                String userPassword=input.nextLine();
                                
                                if( admin.findUser(userEmail, userPassword) != null ){
                                    System.out.println("this email and password already exist.Choose a different email or password!");
                                }else{
                                
                                admin.registerUser(username,userPassword,userEmail);
                                
                                }
                                
                            }
                            break;
                        default:
                            System.out.println("this option is not available!");
                            break;
                    }
                    
                    break;
                default:
                    System.out.println("Please choose an option betwenn 0-5:");
                    
               
            }
        }
        
        
        
    }
    
}
