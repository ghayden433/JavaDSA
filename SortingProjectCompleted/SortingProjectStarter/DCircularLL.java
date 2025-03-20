/**
 * Represents a doubly-linked circular linked list
 * 
 * This circular doubly-linked list only uses a head pointer - no tail pointer.
 * 
 * @version Starter Code
 * @author Hayden Gillen
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
        // new node with value of value
        Node prepNode = new Node(value);
        
        if (head != null){
            if (head.next == head){ // single item list
                //point the new node at the first item of the list
                prepNode.next = head;
                //point new first item previous to the last item of the list
                prepNode.prev = head.prev;
                //point last node to new first node
                head.prev.next = prepNode;
                //point last item previous to first
                head.prev = prepNode;
                //make added node the head
                head = prepNode;
            }
            else{
                //point the new node at the first item of the list
                prepNode.next = head;
                //point new first item previous to the last item of the list
                prepNode.prev = head.prev;
                //point last node to new first node
                head.prev.next = prepNode;
                //point old first node at new first node
                head.prev = prepNode;
                //make added node the head
                head = prepNode;
            }
        }
        else { // empty list 
            //make the head point at the new node
            head = prepNode;
            //make the previous and next node point back to the first node
            prepNode.prev = prepNode;
            prepNode.next = prepNode;
        }
    }

    /**
     * Adds value to the end of the list
     *
     * @param value to be added
     */
    public void append(int value) {
        //create new node to append
        Node appNode = new Node(value);
        
        if (head != null){
            // head.prev is the last item in the list so we point it to the new last node
            head.prev.next = appNode;
            //new node point previous to last item
            appNode.prev = head.prev;
            //point head previous to new end of list
            head.prev = appNode;
            //point new node next to front of list
            appNode.next = head;
        }
        else { // empty list
            //makes a single item list
            //make the head point at the new node
            head = appNode;
            //make the previous and next node point back to the first node
            appNode.prev = appNode;
            appNode.next = appNode;
        }
    }

    /**
     * removes the first occurrence of item from the list.
     *
     * @param item to be removed
     * @returns true if item removed; false otherwise
     */
    public boolean remove(int item) {
        if (head == null) { //empty list
            return false;
        }
        
        
        //if list is single item
         if (head.value == item && head == head.next){
            head = null;
            return true;
        }
        
        //find the index of where the item is if there is a list
        int index = -1;
        if (head != null){
            index = indexOf(item);
        }
       
        //node to hold the node we want to remove, and the previos and next
        Node curNode = head;
        Node sucNode;
        Node predNode;
        
        if (index != -1){
            //finds the node at the specific index and the ones before and after
            for (int i = 0; i < index; i++){
                curNode = curNode.next;
            }
            sucNode = curNode.next;
            predNode = curNode.prev;
            
            //handles if the first item is being removed
            if (index == 0){
                head = sucNode;
            }
            
            //point the node before and after at each other to remove middle node
            predNode.next = sucNode;
            sucNode.prev = predNode;
            
            return true;
        }
        
        return false;

    }

    /**
     * Removes the first value in the list
     * @returns true if item removed; false otherwise
     */
    public boolean remove() {
        if (head == null){ // empty list
            return false;
        } 
        if (head != null && head.next == head){ // single item list
            head = null;
            return true;
        }
        else {
            // new variables to make it easy to read
            Node predNode = head.prev;
            Node sucNode = head.next;
            
            //move head to next node and point the nodes at each other to remove first value
            head = sucNode;
            sucNode.prev = predNode;
            predNode.next = sucNode;
            return true;
        }
    }

    /**
     * Empties the list
     */
    public void empty() {
        // head is the only way to start access to the list so make it point to nothing and there is no list
        head = null;
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
        //holds what node we are on
        Node curNode = head;
        //holds the number of loops so we can return the index
        int loopNum = 0;
        if (head == null){// empty list
            return -1;
        }
        
        do{
            if (curNode.value == value){
                return loopNum; 
            }
            //move to the next node
            curNode = curNode.next;
            loopNum++;
        } while (curNode != head);
        
        return -1;
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
