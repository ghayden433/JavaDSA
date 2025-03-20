import java.util.ArrayList;

/**
 * CSCI 220 - Project 2
 * Carnival Simulation.
 *
 * This class creates a MIN HEAP built on an array. The size of the heap should
 * only be limited by the hardware of the computer.
 * @author Liz Johnson
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
        
        return true;
    }

    /**
     * Remove and return the minimum value in the heap.
     *
     * @return event with min value or null if heap empty
     *
     */
    public Event remove() {
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
        return null;
    }

    /**
     * Returns without removing the minimum value in the heap.
     *
     * @return event with min value or null if heap empty
     *
     */
    public Event peek() {
        return null;
    }

    /**
     * @return the number of items in the heap
     *
     */
    public int size() {
        return 0;
    }

    /**
     * @return true if heap is empty. False otherwise.
     */
    public boolean isEmpty() {
        return true;
    }

    /**
     * Doubles the capacity of the heap. This method should also copy over all
     * elements from the old array to the new array.
     */
    private void doubleArray() {
        
    }

    /**
     * Once something is added to the bottom of the heap, this method moves it
     * upward until it is in the correct spot.
     *
     * @param index index where element was added
     */
    private void bubbleUp(int index) {
        
    }

    /**
     * Once something is swapped to the top of the heap, this method will move
     * it downwards until it is the correct spot.
     *
     * @param index index where item is that is bubbled down
     */
    private void bubbleDown(int index) {
        
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
        
    }
}
