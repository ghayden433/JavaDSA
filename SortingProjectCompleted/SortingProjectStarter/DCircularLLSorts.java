import java.util.ArrayList;

/**
 * Sorts for linked list
 *
 * @author Hayden Gillen
 * @version 1/24
 */
public class DCircularLLSorts
{
       
    /**
     * Constructor for objects of class DLLSorts
     */
    public DCircularLLSorts()
    {
        
    }

    /**
     * Insertion Sort on doubly-linked circular list
     * @param list list to be sorted
     */
    public static void insertionSort(DCircularLL list) {
        //get list length and store it
        int nodeCount = listLength(list);
        Node curNode = list.head;
        Node holdNode;
        
        //loop to move through each index of the list for the next number to sort
        for (int i = 1; i <= nodeCount; i++){
            holdNode = curNode;
            
            //loops through each previous node until the previous item is not less than the number were sorting
            //also terminates when it reaches the beginning of the list
            while (holdNode != list.head && (holdNode.value < holdNode.prev.value)) {
                //calls swap to swap the current node value with the one before it
                swap(holdNode, holdNode.prev);
                
                //sets the current node were observing to the position it has been moved to
                holdNode = holdNode.prev;
            }
            
            //move to the next node
            curNode = curNode.next;
        }
    }
    
    /**
     * Radix Sort on doubly-linked circular list
     * @param list list to be sorted
     */
    public static void radixSort(DCircularLL list) {
        //make 10 buckets and most digits and pow10 for calculating digits later
        ArrayList<Integer> [] buckets = new ArrayList[10];
        int mostDigits = getRadixMaxDigits(list);
        int pow10 = 1;
        
        //list length and bucketNum to hold which bucket the number goes in later
        int nodeCount = listLength(list);
        int bucketNum;
        
        for (int digits = 0; digits < mostDigits; digits++){
            //initialize in here so that the buckets are empty when the loop starts
            for (int i = 0; i < 10; i++){    
                buckets[i] = new ArrayList<Integer>();
            }

            Node curNode = list.head;
            //puts items in buckets
            do{
                //find digit for which bucket the value goes into
                bucketNum = (curNode.value % (10 * pow10) / pow10);
                
                //add to bucket
                buckets[bucketNum].add(curNode.value); 
                
                //move to next node
                curNode = curNode.next;
            } while (curNode != list.head);
            //move pow10 to the next power of 10 so the next largest digit is selected on the next iteration
            pow10 = pow10 * 10;
            
            //put the buckets back into the linked list 
            //Arraylist holds the values and the LL values are replaced in order
            curNode = list.head;
            for (int i = 0; i < buckets.length; i++){
                for (int j = 0; j < buckets[i].size(); j++){
                    curNode.value = buckets[i].get(j);
                    curNode = curNode.next;
                }
            }
        }
        
    }
    
    /**
     * find list length
     * @param list list to be counted
     */
    private static int listLength(DCircularLL list){
        //set starting node and node count
        Node nodeHold = list.head;
        int nodeCount = 0;
        
        //if list is not empty
        if (list.head != null){
            //loop for every node and add one to the count
            do {
                nodeCount++;
                nodeHold = nodeHold.next;
            } while(nodeHold != list.head);
            //return how many nodes were counted (all nodes in list)
            return nodeCount;
        }
        //gets here if list is empty and an empty list has 0 items
        return 0;
    }
    
    /**
     * swap provided nodes' values
     * @param 2 Nodes to be swapped
     */
    private static void swap(Node node1, Node node2){
        int holder;
        holder = node1.value;
        node1.value = node2.value;
        node2.value = holder;
    }
    
    /**
     * finds the greatest length integer in the list and returns it's length
     * @param list linked list to be searched
     */
    private static int getRadixMaxDigits(DCircularLL list){
        //find the largest number
        Integer maxNum = list.head.value;
        Node holdNode = list.head;
        
        do {
            if (holdNode.value > maxNum){
                maxNum = holdNode.value;
            }
            
            holdNode = holdNode.next;
        } while(holdNode != list.head);
        
        //how many digits the largest number has
        int mostDigits = maxNum.toString().length();

        return mostDigits;
    }
}
