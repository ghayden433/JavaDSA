/**
 * Implementation of queue. Front is front of list. End is back of list
 *
 * @author johnsone
 */
public class PLine {

    private int limit; // limit for number of people who can be in line
    private int currentSize; // current number of people in line
    private DCircularLL list; // line

    /**
     * constructor for PLine - DO NOT CHANGE THIS CONSTRUCTOR
     *
     * @param n limit for line size
     */
    public PLine(int n) {
        currentSize = 0;
        limit = n;
        list = new DCircularLL();
    }

    /**
     * Returns number of people in line
     *
     * @return number of people in line
     */
    public int getLineLength() {
        return 0;
    }

    /**
     * Tries to add p to queue. Returns true if the person is successfully added
     * to the queue; false otherwise. You can assume p is not null.
     *
     * @return true if added; false otherwise
     */
    public boolean enqueue(Person p) {
        return false;
    }

    /**
     * returns the Person object that is first in line without removing them.
     * Return null if line is empty
     *
     * @return Person at front of line or null if line empty
     */
    public Person peek() {
        return null;
    }

    /**
     * Dequeues the first x people from the line. If there are not x people in
     * line, it removes however many people are in the line. Returns the number
     * of people removed. You should check to make sure x is not negative.
     */
    public int dequeue(int x) {
        return 0;
    }

    /**
     * Removes first person in line and returns. 
     * Returns null if list empty
     * @return first person or null if list is empty
     */
    public Person dequeue() {
        return null;
    }

    /**
     * Returns true if list is empty; false otherwise
     * @return true if list is empty; false otherwise
     */
    public boolean isEmpty() {
        return true;
    }
    
    /**
     * Creates a string representing PLine DO NOT CHANGE THIS METHOD
     */
    public String toString(){
        return "Front to back "+list+" Length "+getLineLength();
    }
}
