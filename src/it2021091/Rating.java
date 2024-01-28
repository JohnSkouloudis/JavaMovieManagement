/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it2021091;

/**
 *
 * @author John skoul
 */
public class Rating {
    
    private Show show;
    private double grade;

    public Rating(Show show, double grade) {
        this.show = show;
        this.grade = grade;
    }
    
    

    public void setShow(Show show) { 
        this.show = show;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Show getShow() {
        return show;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Rating{" + "show=" + show.getTitle() + ", grade=" + grade + '}';
    }
    
    
    
}
