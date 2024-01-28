/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it2021091;

import static it2021091.It2021091.usersList;
import static it2021091.It2021091.personsList;
import static it2021091.It2021091.showsList;

/**
 *
 * @author John skoul
 */
public class Data {

    public Data() {
        //ενδεικτικοι users
        User user1=new User("user1","12345","user1@yahoo.gr");
        User user2=new User("user2","123456","user2@gmail.com");
        User user3=new User("user3","1234567","user3@gmail.com");
        User user4=new User("user4","1234567","user4@gmail.com");
        User user5=new User("user5","1234567890","user5@hotmail.com");
        
        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);
        usersList.add(user4);
        usersList.add(user5); 
        
        //ενδεικτικα persons
        Person person1=new Person("Martin Scorsese","17/11/1942","USA","");
        personsList.add(person1);
        Person person2=new Person("Robert De Niro","1/7/1943","USA","");
        personsList.add(person2);
        Person person3=new Person("Ray Liotta","18/12/1954","USA","");
        personsList.add(person3);
        Person person4=new Person("Lorraine Bracco","2/10/1954","USA","");
        personsList.add(person4);
        
        Person person5=new Person("Chad Stahelski","20/9/1968","USA","www.chadstahelski.com");
        personsList.add(person5);
        Person person6=new Person("Keanu Reeves","2/9/1964","Canada","");
        personsList.add(person6);
        Person person7=new Person("Michael Nyqvist","8/11/1960","Sweden","");
        personsList.add(person7);
        Person person8=new Person("Alfie Allen","12/9/1986","UK","");
        personsList.add(person8);
        
        Person person9=new Person("Christopher Nolan","30/7/1970","UK","");
        personsList.add(person9);
        Person person10=new Person("Matthew McConaughey","4/11/1959","USA","");
        personsList.add(person10);
        Person person11=new Person("Anne Hathaway","12/11/1989","USA","");
        personsList.add(person11);
        Person person12=new Person("Jessica Chastain","24/3/1977","USA","");
        personsList.add(person12);
        
        Person person13=new Person("Robert Zemeckis","14/5/1952","USA","");
        personsList.add(person13);
        Person person14=new Person("Tom Hanks","9/7/1956","USA/Greece","");
        personsList.add(person14);
        Person person15=new Person("Robin Wright","8/4/1966","USA","");
        personsList.add(person15);
        Person person16=new Person("Gary Sinise","17/3/1955","USA","");
        personsList.add(person16);
        
        Person person17=new Person("David Fincher","28/8/1962","USA","");
        personsList.add(person17);
        Person person18=new Person("Brad Pitt","18/12/1963","USA","");
        personsList.add(person18);
        Person person19=new Person("Edward Norton","18/8/1969","USA","");
        personsList.add(person19);
        Person person20=new Person("Helena Carter","26/5/1966","UK","");
        personsList.add(person20);
        
        Person person21=new Person("Lana Wachowski","21/6/1965","USA","");
        personsList.add(person21);
        Person person22=new Person("Laurence Fishburne","30/7/1961","USA","");
        personsList.add(person22);
        Person person23=new Person("Carrie-Anne Moss","21/8/1967","Canada","");
        personsList.add(person23);
        
        Person person24=new Person("Michael Hirst","21/9/1952","UK","www.michaelhirst.uk");
        personsList.add(person24);
        Person person25=new Person("Travis Fimmel","15/7/1979","Australia","www.travisfimmel.au");
        personsList.add(person25);
        Person person26=new Person("Katheryn Winnick","17/12/1977","Canada","");
        personsList.add(person26);
        Person person27=new Person("Alex Høgh Andersen","20/5/1994","Denmark","");
        personsList.add(person27);
        
        Person person28=new Person("Vince Gilligan","10/2/1967","USA","www.vincegilligan.com");
        personsList.add(person28);
        Person person29=new Person("Bryan Cranston","7/2/1956","USA","");
        personsList.add(person29);
        Person person30=new Person("Aaron Paul","27/8/1979","USA","");
        personsList.add(person30);
        Person person31=new Person("Giancarlo Esposito","26/4/1958","USA","");
        personsList.add(person31);
        
        Person person32=new Person("David Benioff","25/9/1970","USA","");
        personsList.add(person32);
        Person person33=new Person("Peter Dinklage","11/6/1969","USA","");
        personsList.add(person33);
        Person person34=new Person("Emilia Clarke","23/10/1986","UK","");
        personsList.add(person34);
        Person person35=new Person("Kit Harington","26/12/1986","UK","");
        personsList.add(person35);
        
        Person person36=new Person("Neil Druckmann","5/12/1978","Israel","");
        personsList.add(person36);
        Person person37=new Person("Pedro Pascal","2/4/1975","Chile","");
        personsList.add(person37);
        Person person38=new Person("Bella Ramsey","17/9/2003","UK","");
        personsList.add(person38);
        
        //ενδεικτικα θεαματα
        Show show1=new Show("Goodfellas",1990,"USA",null);
        show1.setDirector( person1);
        show1.addType("drama");
        show1.addType("crime");
        show1.addActor( person2);
        show1.addActor( person3);
        show1.addActor( person4);
        showsList.add(show1);
        
        Show show2=new Show("John Wick",2014,"",null);
        show2.setDirector( person5);
        show2.addType("action");
        show2.addType("crime");
        show2.addType("thriller");
        show2.addActor( person6);
        show2.addActor( person7);
        show2.addActor( person8);
        showsList.add(show2);
        
        
        Show show3=new Show("Interstellar",2014,"USA",null);
        show3.setDirector( person9);
        show3.addType("drama");
        show3.addType("adventure");
        show3.addType("sci-fi");
        show3.addActor( person10);
        show3.addActor( person11);
        show3.addActor( person12);
        showsList.add(show3);
        
        Show show4=new Show("Forrest Gump",1994,"USA",null);
        show4.setDirector( person13);
        show4.addType("drama");
        show4.addType("romance");
        show4.addActor( person14);
        show4.addActor( person15);
        show4.addActor( person16);
        showsList.add(show4);
        
        Show show5=new Show("Fight Club",1999,"USA",null);
        show5.setDirector( person17);
        show5.addType("drama");
        show5.addActor( person18);
        show5.addActor( person19);
        show5.addActor( person20);
        showsList.add(show5);
        
        Show show6=new Show("The Matrix",1999,"USA",null);
        show6.setDirector( person21);
        show6.addType("action");
        show6.addType("sci-fi");
        show6.addActor( person6);
        show6.addActor( person22);
        show6.addActor( person23);
        showsList.add(show6);
        
        Series series1= new Series(6,"2020","Vikings",2014,"Canada/Ireland",null);
        series1.setDirector( person24 );
        series1.addType("drama");
        series1.addType("adventure");
        series1.addType("action");
        series1.addActor( person25);
        series1.addActor( person26);
        series1.addActor( person27);
        series1.setEpisodesForSeason(1, 9);
        series1.setEpisodesForSeason(2, 10);
        series1.setEpisodesForSeason(3, 10);
        series1.setEpisodesForSeason(4, 20);
        series1.setEpisodesForSeason(5, 20);
        series1.setEpisodesForSeason(6, 20);
        showsList.add(series1);
        
        
        Series series2= new Series(5,"2013","Breaking Bad",2008,"USA",null);
        series2.setDirector( person28 );
        series2.addType("drama");
        series2.addType("crime");
        series2.addType("thriller");
        series2.addActor( person29);
        series2.addActor( person30);
        series2.addActor( person31);
        series2.setEpisodesForSeason(1, 7);
        series2.setEpisodesForSeason(2, 13);
        series2.setEpisodesForSeason(3, 13);
        series2.setEpisodesForSeason(4, 13);
        series2.setEpisodesForSeason(5, 16);       
        showsList.add(series2);
        
        Series series3= new Series(8,"2019","Game of Thrones",2011,"USA",null);
        series3.setDirector( person32 );
        series3.addType("drama");
        series3.addType("action");
        series3.addType("adventure");
        series3.addActor( person33);
        series3.addActor( person34);
        series3.addActor( person35);
        series3.setEpisodesForSeason(1, 10);
        series3.setEpisodesForSeason(2, 10);
        series3.setEpisodesForSeason(3, 10);
        series3.setEpisodesForSeason(4, 10);
        series3.setEpisodesForSeason(5, 10);
        series3.setEpisodesForSeason(6, 10);
        series3.setEpisodesForSeason(7, 7);
        series3.setEpisodesForSeason(8, 6);
        showsList.add(series3);
        
        Series series4=new Series(1,"-","The Last of Us",2023,"USA",null);
        series4.setDirector(person36 );
        series4.addType("drama");
        series4.addType("action");
        series4.addType("adventure");
        series4.addActor( person37);
        series4.addActor( person38);
        series4.setEpisodesForSeason(1, 10);
        showsList.add(series4);
        
        //ενδεικτικα ratings
        user1.addRating(show1, 6.4);
        user1.addRating(show2, 1.8);
        user1.addRating(show3, 3.8);
        user1.addRating(show4, 5.7);
        user1.addRating(show5, 6.2);
        user1.addRating(show6, 7.2);
        user1.addRating(series1, 8.2);
        user1.addRating(series2, 9.0);
        user1.addRating(series3, 7.5);
        user1.addRating(series4,  8.6);
        
        user2.addRating(show1, 8.6);
        user2.addRating(show2, 4.5);
        user2.addRating(show4, 6.4);
        user2.addRating(series1, 9.8);
        user2.addRating(series2, 3.1);
        user2.addRating(series3, 7.2);
        
        user3.addRating(show3, 2.7);
        user3.addRating(show5, 9.2);
        user3.addRating(show6, 4.9);
        user3.addRating(series4, 10.0);
        
        user4.addRating(show2,7.7);
        user4.addRating(series2,2.5);
        user4.addRating(show6,5.6);
        user4.addRating(show3,1.9);
              
        user5.addRating(show1, 7.4);
        user5.addRating(show2, 6.2);
        user5.addRating(show3, 1.4);
        user5.addRating(show4, 3.9);
        user5.addRating(show5, 5.1);
        user5.addRating(show6, 8.7);
        user5.addRating(series1, 9.6);
        user5.addRating(series2, 4.7);
        user5.addRating(series3, 8.8);
        user5.addRating(series4, 1.8);
        
        //ενδεικτικοι αγαπημενοι για καθε user
        user1.addFavourite(person1);
        user1.addFavourite(person2);
        user1.addFavourite(person3);
        user1.addFavourite(person4);
        user1.addFavourite(person5);
        user1.addFavourite(person6);
        user1.addFavourite(person7);
        
        user2.addFavourite(person8);
        user2.addFavourite(person9);
        user2.addFavourite(person10);
        user2.addFavourite(person11);
        user2.addFavourite(person12);
        
        
        user3.addFavourite(person13);
        user3.addFavourite(person14);
        user3.addFavourite(person15);
        user3.addFavourite(person16);
        user3.addFavourite(person17);
        user3.addFavourite(person18);
        user3.addFavourite(person19);
        user3.addFavourite(person20);
        user3.addFavourite(person21);
        
        user4.addFavourite(person22);
        user4.addFavourite(person23);
        user4.addFavourite(person24);
        user4.addFavourite(person25);
        
        user5.addFavourite(person26);
        user5.addFavourite(person27);
        user5.addFavourite(person28);
        user5.addFavourite(person29);
        user5.addFavourite(person30);
        user5.addFavourite(person31);
        user5.addFavourite(person32);
        user5.addFavourite(person33);
        user5.addFavourite(person34);
        user5.addFavourite(person35);
        user5.addFavourite(person36);
        user5.addFavourite(person37);
        user5.addFavourite(person38);
                    
    }
    
    
    
    
}
