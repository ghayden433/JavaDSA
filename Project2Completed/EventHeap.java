import java.util.ArrayList;

/**
 * CSCI 220 - Project 2
 * Carnival Simulation.
 *
 * This class creates a MIN HEAP built on an array. The size of the heap should
 * only be limited by the hardware of the computer.
 * @author Hayden Gillen
 * @version 2023.10 Built the project from scratch.
 */
public class EventHeap {

    private int size; // number of events in heap
    private Event[] heap; 

    /**
     * Create an empty heap. DO NOT CHANGE THIS CONSTRUCTOR
     * @param n initial limit of heap
     */
    public EventHeap(int n) {
        size = 0;
        heap = new Event[n];
    }

    /**
     * Add an item to the heap.
     *
     * @param event
     * @return true if event is successfully added. False otherwise.
     */
    public boolean add(Event event) {
        //double array if we need more space
        if (heap[heap.length-1] != null){
            doubleArray();
        }
        
        //add event to the array
        heap[size] = event; 
        size++;
        
        //bubble up the heap
        if (heap[0] != null){
            bubbleUp(size - 1);  
        }
        return true;
    }

    /**
     * Remove and return the minimum value in the heap.
     *
     * @return event with min value or null if heap empty
     *
     */
    public Event remove() {
        Event returnItem = heap[0]; 
        if (returnItem != null) {
            //Swap first and last item, which moves last item to top of tree, and then delete the last item (min number)
            swap(0, size - 1);
            heap[size - 1] = null;
            
            //bubble down to keep min heap structure, make size decrease by one becuase we removed and return the min number.
            if (size > 1){
                bubbleDown(0);
            }
            size--;
            return returnItem;
        }
        return null;
    }

    /**
     * Removes the next x events (in increasing order). If there are not x events, 
     * it removes however many events are in the heap. Returns a list of the removed
     * events in increasing order. You should check to make sure x is not negative.
     * If no events are removed, return an empty list.
     * @param x number of events to remove
     * @return list with events in increasing order
     *
     */
    public ArrayList<Event> remove(int x) {
        //list to hold the items
        ArrayList<Event> removedList = new ArrayList<Event>();
        //prevents negative numbers of removal
        if (x < 0){
            return removedList;
        }
        
        for (int i = 0; i < x; i++){
            //see if there is an item to remove
            if(peek() != null){
                removedList.add(remove());
            }
        }
        
        return removedList;
    }

    /**
     * Returns without removing the minimum value in the heap.
     *
     * @return event with min value or null if heap empty
     *
     */
    public Event peek() {
        if (size > 0){
            return heap[0];
        }
        return null;
    }

    /**
     * @return the number of items in the heap
     *
     */
    public int size() {
        return size;
    }

    /**
     * @return true if heap is empty. False otherwise.
     */
    public boolean isEmpty() {
        if (heap[0] != null){    
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * Doubles the capacity of the heap. This method should also copy over all
     * elements from the old array to the new array.
     */
    private void doubleArray() {
        //creates new array that is twice as long
        Event[] tempHeap = new Event[heap.length * 2];
        
        //copy over elements to longer array
        for (int i = 0; i < heap.length; i++){
            tempHeap[i] = heap[i];
        }
        
        //put the new array where in place of the old array
        heap = tempHeap;
    }

    /**
     * Once something is added to the bottom of the heap, this method moves it
     * upward until it is in the correct spot.
     *
     * @param index index where element was added
     */
    private void bubbleUp(int index) {
        while(index > 0){
            int parentIndex = (index-1) / 2;
            //if its in the right spot return
            if (heap[index].getEventTime() >= heap[parentIndex].getEventTime()){
                return;
            }
            //swap it up the tree
            else {
                swap(index, parentIndex);
                index = parentIndex;
            }
        }
    }

    /**
     * Once something is swapped to the top of the heap, this method will move
     * it downwards until it is the correct spot.
     *
     * @param index index where item is that is bubbled down
     */
    private void bubbleDown(int index) {
        //find child nodes and set initial value
        int childIndex = 2 * index + 1;
        double value = heap[index].getEventTime();
           
        
        while (childIndex < size){
            double minValue = value;
            int minIndex = -1;
            
            for (int i = 0; i < 2 && ((i + childIndex) < size - 1); i++){
                if (heap[i + childIndex].getEventTime() < minValue) {
                    minValue = heap[i + childIndex].getEventTime();
                    minIndex = i + childIndex;
                }
            }
        
            if (minValue == value) {
                return;
            }
            else {
              swap(index, minIndex);
              index = minIndex;
              childIndex = 2 * index + 1;
            }
        }
    }

    /**
     * Creates a string representation of the tree. DO NOT CHANGE THIS METHOD
     *
     * @return String representing heap
     */
    public String toString() {
        String s = "";
        int nodesPerLevel = 0;
        int maxNodesPerLevel = 1;
        for (int i = 0; i < size; i++) {
            s += heap[i] + "  ";
            nodesPerLevel++;
            if (nodesPerLevel >= maxNodesPerLevel) {
                s += "\n"; //New Line 
                maxNodesPerLevel *= 2;
                nodesPerLevel = 0;
            }
        }
        return s;
    }

    /**
     * Swaps two elements in the heap.
     *
     * @param index1 index of first item
     * @param index2 index of second item
     */
    private void swap(int index1, int index2) {
        Event temp;
        
        temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
}
