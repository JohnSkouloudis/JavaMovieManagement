/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it2021091;

import static it2021091.It2021091.personId;

/**
 *
 * @author John skoul
 */
public class Person {
    
    protected int id;
    protected String fullName;
    protected String birthDate;
    protected String country;
    protected String website;

    public Person( String fullName, String birthDate, String country, String website) {
        this.id =personId;
        personId++;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.country = country;
        this.website = website;
    }
    
    
    

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getCountry() {       
        return country;
    }

    public String getWebsite() {
        return website;
    }

    @Override
    public String toString() {
        return "Person:[" +  "\n" +
                "Id=" + id +  " , " +
                "fullName=" + fullName + " , " +
                "birthDate=" + birthDate + " , " +
                "country=" + country + " , " +
                "website=" +  website + "]" + "\n" ;
    }
    
    
    
}
