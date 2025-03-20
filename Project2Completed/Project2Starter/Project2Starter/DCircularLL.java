/**
 * 
 * This class is your DLL. Do not change this file.
 * 
 * REMEMBER: A circular linked list only uses a head pointer - no tail pointer.
 * 
 */

/**
 * @version Starter Code
 * @author Katie Timmerman and Liz Johnson
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
    public void prepend(Person value) {
        //if the list is empty, point the head pointer to the new node 
        // and its prev and next pointers to itself
        if (head == null) {
            head = new Node(value);
            head.next = head;
            head.prev = head;
        } 
        //else point the next pointer of the last node to  
        // the new node, the prev pointer of the new node to the 
        // last node, the next pointer of the new node to the old 
        // first node, and the prev pointer of the old next node 
        // to the new node
        else {
            Node n= new Node(value);
            n.prev=head.prev;
            n.next=head;
            head.prev.next=n;
            head.prev=n;
            head=n;
        }
    }

    /**
     * Adds value to the end of the list
     *
     * @param value to be added
     */
    public void append(Person value) {
        //if the list is empty, point the head pointer to the 
        // new node and its prev and next pointers to itself
        if (head == null) {
            head = new Node(value);
            head.next = head;
            head.prev = head;
        } 
        // 1 node
        else if(head==head.next) {
            Node n = new Node(value);
            head.next = n;
            head.prev = n;
            n.prev = head;
            n.next = head;
            // more than 1 node
        } else {
            Node n = new Node(value);
            head.prev.next = n;
            n.prev = head.prev;
            head.prev = n;           
            n.next = head;
        }
    }

    /**
     * removes the first occurrence of item from the list.
     *
     * @param item to be removed
     */
    public boolean remove(Person item) {
        if(head==null){
            return false;
        }
        else if (head==head.next){
            if (head.value.equals(item)){
                head=null;
                return true;
            } else {
                return false;
            }
        } 
        else {
            Node current = head;            
            while (current != head.prev) {               
                if (current.value.equals(item)) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    if (current==head){
                        head=head.next;
                    }
                    return true;
                } else {
                    current = current.next;                   
                }
            }
            if (current.value.equals(item)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                if (current==head){
                    head=head.next;
                }
                return true;
            }
            return false;
        }
    }


    /**
     * Removes the first value in the list
     * @return removed value or null if list empty
     */
    public Person remove() {
        if (head==null){
            return null;
        }
        else if (head==head.next){
            Person save=head.value;
            head=null;
            return save;
        } else{
            Person save=head.value;
            head.prev.next = head.next;
            head.next.prev = head.prev;
            head=head.next;
            return save;
        }
    }

    /**
     * Empties the list
     */
    public void empty() {
        head=null;
    }
    
    /**
     * Return first item in list or null if empty list
     * @return first item in list or null if empty list
     */
    public Person getFirst(){
        if (head==null){
            return null;
        }
        return head.value;
    }

    /**
     * Returns the location of the first occurrence of the value in the list.
     * 
     * @param value value to be located
     * @return 0 if it is the first item. Return -1 if it isn't in the list
     */
    public int indexOf(Person value) {
        //checks if the list is empty, ends the function with -1 return if it is
        if (head != null) {
            int index = 0;
            Node current = head;
            //traverses the list incrementing the index, 
            // stops before last node
            while (current != head.prev) {
                //if the value of the currrent node is the target value,
                // then return the index
                if (current.value.equals(value)) {
                    return index;
                } else {
                    current = current.next;
                    index++;
                }
            }
            //checks if the value of the last node is the target value, returns the index if yes and -1 if no
            if (current.value.equals(value)) {
                return index;
            }

        }
        return -1;
    }

    /**
     * This is the method called when a DCircularLL is passed to System.out.print It
     * determines what is printed.
     * 
     * For this project I printed the list forward and backward.
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
