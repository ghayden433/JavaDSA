
/**
 * This is a Node class to be used in the linked list.
 * Everything is public in order to simplify the code that
 * uses this class.
 *
 * @author Katie Timmerman (modified by Liz Johnson)
 * @version 1/24
 */

public class Node {

    public Node prev;
    public Node next;
    public int value;

    /**
     * Constructor for Node
     * @param value value contained in Node
     */
    public Node(int value) {
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
    public Node(Node prev, int value, Node next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }
}
