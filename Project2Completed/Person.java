/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * CSCI 220 - Project 2
 * Simulation.
 * 
 * This class holds the details about an individual.
 * 
 * 
 */

/**
 *
 * @author johnsone
 */
public class Person {
    //How many minutes past park opening time that they arrive
    private double arrivalTime; 
    //How many minutes past park opening time that they wish to leave
    private double timeLeaving; 
    private int ID; 
    public Person(double arrivalTime, double timeLeaving, 
    int ID) {
        this.arrivalTime = arrivalTime;
        this.timeLeaving = timeLeaving;
        this.ID = ID;
    }

    /**
     * @return the arrivalTime
     */
    public double getArrivalTime() {
        return arrivalTime;
    }

    /**
     * @return the timeLeaving
     */
    public double getTimeLeaving() {
        return timeLeaving;
    }

    /**
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param arrivalTime the arrivalTime to set
     */
    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * @param timeLeaving the timeLeaving to set
     */
    public void setTimeLeaving(double timeLeaving) {
        this.timeLeaving = timeLeaving;
    }

    /**
     * @return string representing person
     */
    public String toString(){
        return "[Person "+ID+": "+arrivalTime+":"+timeLeaving+"]";
    }

    /**
     * @return true if ID, arrivalTime,timeLeaving are the same as obj
     */
    public boolean equals(Object obj){
        if (this == obj) {    
            return true;    
        }    
        if (obj instanceof Person) {    
            Person p = (Person) obj;    
            return (p.ID==ID && p.arrivalTime==arrivalTime &&
                p.timeLeaving==timeLeaving);
        }    
        return false;  
    }
}
