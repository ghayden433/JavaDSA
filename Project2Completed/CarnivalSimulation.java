/**
 * CSCI 220 - Project 2
 * Carnival Simulation.
 * 
 * This class runs the actual simulation. It requires most other classes within this
 * package. The method start() is where the simulation begins.
 * 
 */
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Kathleen Timmerman, modified by Liz Johnson
 * @version 2024.02
 */

public class CarnivalSimulation {

    //Number of minutes after park opens before the park closes
    private static final double PARK_CLOSING_TIME = 300.0; 
    // People will not join a new line if there is only 15 
    //   minutes before they intend to leave.
    private static final double CUSHION_FOR_LEAVING = 15; 
    // This is used as a value for ride time length 
    //   and it * 10 is the minumum number of people on a ride at once
    private static final int MIN_MODIFIER = 3; 
    //Number of rides in the park. With current setup, as the number 
    //   of rides increase, the rides get longer but hold more people
    private static final int NUM_RIDES = 10; 
    // How long a ride will wait before starting to run after the 
    //   first person gets in line.
    private static final double WAIT_TIME = 4.0;
    // How long it takes to unload and load a ride
    private static final double LOAD_TIME = 2.5; 
    
    //The number of minutes since the park opened.
    private static double currentTime = 0.0; 
    //A list of all rides in the park
    private static final ArrayList<Ride> RIDES = new ArrayList<>(); 
    // A priority queue to hold upcoming events
    private static final EventHeap EVENTS = new EventHeap(100); 
    //Count of how many people left early because lines were too long.
    private static int numLeaveEarly = 0; 
    //Count of how many people visited the carnival
    private static int numVisitors = 0; 

    /**
     * This starts the simulation.
     * It initializes the ride, loads the starting events of people arriving, and
     * dequeues the next events from the heap. Once there are no more events in the queue,
     * this method will print the number of people who left early and the simulation ends.
     */
    public static void start() {
        //load RIDES
        for (int i = 0; i < NUM_RIDES; i++) {
            RIDES.add(new Ride(i,i + MIN_MODIFIER, (i + MIN_MODIFIER) * 10));
        }

        loadPeople();

        //holds percentage of ride queue capacity 
        double PCT;
        // holds highest or lowest or running total of percentages for average (to be divided later)
        // in an array each index number is the number of ride capacity / 10
        // that is why the first three are -1 so they are not used because rides range from 30-120 capacity
        double[] lowest = {-1, -1, -1, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,};
        double[] highest = {-1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,};
        double[] averageTotal = {-1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,};
        //total number each ride operates
        int[] total = {-1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,};
            
        // Run the simulation
        while (!EVENTS.isEmpty()) {
            Event event = EVENTS.remove();
            currentTime = event.getEventTime();
            
            switch (event.getEventType()) {
                case START_RIDE:
                    Ride rs = (Ride) event.getEventTarget();
                    if(rs.startRide()){
                        Event e = new Event(EventType.END_RIDE, 
                                currentTime + rs.getRideTime(), rs );
                        EVENTS.add(e);
                        
                    }
                    break;
                case END_RIDE:
                    Ride re = (Ride) event.getEventTarget();
                    ArrayList<Person> exiting = re.endRide();
                    while(!exiting.isEmpty()){
                        Person p = exiting.remove(0);
                        if(currentTime + CUSHION_FOR_LEAVING < p.getTimeLeaving()){
                            findARide(p);
                        }
                    }
                    if (re.getLineLength() >= 1){
                        Event e = new Event(EventType.START_RIDE, currentTime + LOAD_TIME, re );
                        EVENTS.add(e);
                    }
                    
                    //get the index for the array for each ride
                    int ind = re.getCapacity() / 10;
                    
                    //find percent of line that is full
                    PCT = re.getLineLength() / re.getCapacity();
                    
                    //if its a min or max save it
                    if (PCT < lowest[ind]){
                        lowest[ind] = PCT;
                    }
                    if (PCT > highest[ind]){
                        highest[ind] = PCT;
                    }
                    
                    //add the percentage to the running total and add 1 to count the ride operation number
                    averageTotal[ind] += PCT;
                    total[ind]++;
                    
                    //System.out.println(re.getCapacity());
                    
                    
                    break;
                case ARRIVE_AT_CARNIVAL:
                    findARide((Person) event.getEventTarget());
                    break;
            }//end switch
        }//end while

        //buffer to make output easier to read 
        //then each loop just prints the corresponding value for each ride
        //goes 3-12 because thats the ride capacity options
        System.out.println("");
        System.out.println("////////////");
        System.out.println("");
        
        
        System.out.println(numVisitors + " people visited and "+numLeaveEarly + " people left early.");
        
        //lowest line length
        for (int i = 3; i <= 12; i++){
            System.out.println("Lowest of ride with capacity " + i*10 + ":");
            System.out.println(lowest[i]);
        }
        
        System.out.println("");
        System.out.println("////////////");
        System.out.println("");
        
        //highest line length
        for (int i = 3; i <= 12; i++){
            System.out.println("Highest of ride with capacity " + i*10 + ":");
            System.out.println(highest [i]);
        }
        
        System.out.println("");
        System.out.println("////////////");
        System.out.println("");
        
        //average line length, this is where the running total percentage is divided by total runs of ride
        //to find the average
        for (int i = 3; i <= 12; i++){
            System.out.println("Average of ride with capacity " + i*10 + ":");
            System.out.println(averageTotal[i] / total[i]);
        }
        
        System.out.println("");
        System.out.println("////////////");
        System.out.println("");
        
        //just print the total runs of each ride
        for (int i = 3; i <= 12; i++){
            System.out.println("Total Ride Operations of ride with capacity " + i*10 + ":");
            System.out.println(total[i]);
        }
    }

    /**
     * This method randomly choose a new ride for the person.
     * If the ride they find has no one else in line and the ride isn't currently running,
     * a START_RIDE event will be created.
     * @param p 
     */
    private static void findARide(Person p) {

        //A list of Indices for all rides. 
        ArrayList<Integer> rideOptions = new ArrayList<>();
        for (int i = 0; i < NUM_RIDES; i++) {
            rideOptions.add(i);
        }

        //Randomly remove one index from the list of indexs. See if there is room in that line.
        //If ride is found, add that person to the line. Create a START_RIDE event if the ride wasn't
        //running and no one was in line.
        boolean rideFound = false;
        while (!rideFound && !rideOptions.isEmpty()) {
            int index = (int) (Math.random() * rideOptions.size());
            index = rideOptions.remove(index);

            Ride r = RIDES.get(index);
            if (r.addToLine(p)) {
                rideFound = true;
                if (!r.isRunning() && r.getLineLength() == 1) {
                    Event e = new Event(EventType.START_RIDE, currentTime + WAIT_TIME, r);
                    EVENTS.add(e);
                }
            }
        }

        
        
        //If no ride line had space
        if (!rideFound) {
            numLeaveEarly++;
        }
    }
   
    /**
     * Use the file personFile.txt to load arrival times and lengths of visit.
     * Each line in file will create a ARRIVE_AT_CARNIVAL event.
     */
    private static void loadPeople() {
        double arriveTime, timeHere;

        try {
            File myFile = new File("personFile.txt"); //Finds the file
            Scanner inputFile = new Scanner(myFile); //connects to the file
            int i=0;
            while (inputFile.hasNext()) { //while something to read
                arriveTime = inputFile.nextDouble();
                timeHere = inputFile.nextDouble();
                double leaveTime = arriveTime + timeHere;
                if(leaveTime > PARK_CLOSING_TIME)
                    leaveTime = PARK_CLOSING_TIME;
                Person p = new Person(arriveTime, leaveTime,i);
                Event event = new Event(EventType.ARRIVE_AT_CARNIVAL, arriveTime, p);
                EVENTS.add(event); // add event into heap
                i++;
            }//end while
            numVisitors=i;
            inputFile.close();
        } catch (FileNotFoundException e) {
            System.err.println("File was not found");
            System.exit(0);
        }
    }

}
