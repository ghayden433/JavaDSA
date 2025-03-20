/**
 * CSCI 220 - Project 2
 * Simulation.
 * 
 * This class handles the details of a specific ride from ride times, number of people
 * able to ride at once, whether it is running, and a queue for who is waiting on it.
 * 
 */

import java.util.ArrayList;

/**
 * @author Kathleen Timmerman
 * @version 2023.02
 * Built the project from scratch.
 */

public class Ride {
    //How long the ride is in minutes.
    private final double RIDE_TIME; 
    // How many people can ride the ride at once
    private final int CAPACITY; 
    // People waiting on ride
    private PLine line; 
    //Is the ride running. False at start of day and when no line to load
    private boolean running; 
    //List of persons currently riding ride.
    private ArrayList<Person> onRide = new ArrayList<>(); 
    // Ride ID
    private int ID;

    /**
     * Creates a ride object with a given ride length in minutes and a number of people
     * that can ride the ride at once.
     * @param ID unique ID
     * @param rideTime ride length
     * @param capacity capacity of ride
     */
    public Ride(int ID, double rideTime, int capacity) {
        this.ID = ID;
        this.RIDE_TIME = rideTime;
        this.CAPACITY = capacity;
        this.line = new PLine(capacity);
        running = false;
    }

    /**
     * Adds p to the rides line.
     * @param p person to add to line
     * @return true if added to line, false otherwise
     */
    public boolean addToLine(Person p) {
        return line.enqueue(p);
    }

    /**
     * Returns the length of the ride line.
     * @return line length
     */
    public int getLineLength() {
        return line.getLineLength();
    }

    /**
     * Will load and start the ride if people are waiting.
     * @return true if ride has started, false otherwise
     */
    public boolean startRide() {
        
        if(line.isEmpty()){
            running = false;
            return false;
        }
        
        while(!line.isEmpty()){
            onRide.add(line.dequeue());
        }
        
        return true;
        
    }

    /**
     * Removes people from the ride. Returns the list of person disembarking.
     * @return list of people leaving ride
     */
    public ArrayList<Person> endRide() {
        ArrayList<Person> exiting = onRide;
        onRide = new ArrayList<>();
        
        return exiting;
    }

    /**
     * @return the CAPACITY
     */
    public int getCapacity() {
        return CAPACITY;
    }

    /**
     * @return the RIDE_TIME
     */
    public double getRideTime() {
        return RIDE_TIME;
    }

   
    /**
     * @return the running
     */
    public boolean isRunning() {
        return running;
    }
    
    /**
     * @return ID
     */
    public int getID(){
        return ID;
    }

    /**
     * @param running the running to set
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

}
