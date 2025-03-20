/**
 * Represents a doubly-linked circular linked list
 * 
 * This circular doubly-linked list only uses a head pointer - no tail pointer.
 * 
 * @version Starter Code
 * @author YOUR NAME HERE
 */
class DCircularLL {

    public Node head;
    
    /**
     * creates an empty list
     */
    public DCircularLL() {
        head = null;
    }

    /**
     * Adds value to the start of the list
     *
     * @param value to be added
     */
    public void prepend(int value) {

    }

    /**
     * Adds value to the end of the list
     *
     * @param value to be added
     */
    public void append(int value) {

    }

    /**
     * removes the first occurrence of item from the list.
     *
     * @param item to be removed
     * @returns true if item removed; false otherwise
     */
    public boolean remove(int item) {
        return false;
    }

    /**
     * Removes the first value in the list
     * @returns true if item removed; false otherwise
     */
    public boolean remove() {
        return false;
    }

    /**
     * Empties the list
     */
    public void empty() {

    }

    /**
     * Returns the location of the first occurrence of the value 
     * in the list. Returns 0 if value is the first item, 
     * 1 if it is the second item, etc. Return -1 if it isn't in the list
     * 
     * @param value value to be located
     * @return position of first occurrence of value if in list. Otherwise -1
     */
    public int indexOf(int value) {
        return 0;
    }

    /**
     * Creates string representing list forward and backward
     * @return string representation of list
     */
    @Override
    public String toString() {
        if (head == null) {
            return "Forward: [] Backward: []";
        }
        String strRepresentation = "Forward: [";
        Node cur = head;
        while (cur != head.prev) {
            strRepresentation += cur.value + " ";
            cur = cur.next;
        }
        strRepresentation += cur.value + "] Backward: [";
        
        cur = head.prev;
        while (cur != head) {
            strRepresentation += cur.value + " ";
            cur = cur.prev;
        }
        strRepresentation += cur.value + "]";
        return strRepresentation;
    }

}
