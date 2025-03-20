
/**
 * 
 * This is a Node class to be used in your linked list.
 * @author Liz
 * @version 2/17/24
 */

public class Node {

    public Node prev;
    public Node next;
    public Person value;

    /**
     * Constructor for Node
     * @param value value contained in Node
     */
    public Node(Person value) {
        this.prev = null;
        this.value = value;
        this.next = null;
    }

    /**
     * Constructor for Node
     * @param prev previous pointer
     * @param value value contained in Node
     * @param next next pointer
     */
    public Node(Node prev, Person value, Node next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }
}

