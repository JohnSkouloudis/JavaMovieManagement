/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it2021091;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author John skoul
 */
public class Series extends Show {
   
        private int seasons;
        private int[] episodesPerSeason;
        private String lastYear;

    public Series(int seasons, String lastYear, String title, int firstYear, String country, Person director) {
        super(title, firstYear, country, director);
        this.seasons = seasons;
        this.lastYear = lastYear;
        this.episodesPerSeason= new int[seasons];
    }

    

    public Series(int seasons, int[] episodesPerSeason, String lastYear, String title, int firstYear, ArrayList<String> types, String country, Person director, ArrayList<Person> actors) {
        super( title, firstYear, country, director, types, actors);
        this.seasons = seasons;
        this.episodesPerSeason = episodesPerSeason;
        this.lastYear = lastYear;
    }

    

    public void setSeasons(int seasons) {
        this.seasons = seasons;
        this.episodesPerSeason= new int[seasons];
    }

    public void setEpisodesPerSeason(int[] episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }
         

    public void setEpisodesForSeason(int season, int episodesForSeason) {
        this.episodesPerSeason[season-1] = episodesForSeason;
    }

    public void setLastYear(String lastYear) {
        this.lastYear = lastYear;
    }

    public int getSeasons() {
        return seasons;
    }

    public int[] getEpisodesPerSeason() {
        return episodesPerSeason;       
    }

    public int getEpisodesForSeason(int seasons){
        return episodesPerSeason[seasons-1];
    }
    
    public String getLastYear() {
        return lastYear;
    }
    
    

    @Override
    public String toString() {
        return "Series:{" + "\n" +
                "id=" + id + " , "+
                "title=" + title + " , "+
                "firstYear=" + firstYear + " , "+
                "types=" + types.toString() + " , "+
                "country=" + country + " , "+
                "director=" + director.getFullName() + " , " +
                "actors=" + actors + " , " +               
                "seasons=" + seasons + " ," +
                "episodesPerSeason=" + Arrays.toString(episodesPerSeason) + " , " +
                "lastYear=" + lastYear + "}" + "\n"; 
    }

    
        
        
        
}
