import java.util.ArrayList;

/**
 * Sorting algorithms for ArrayLists.
 *
 * @author Hayden Gillen
 * @version 1/26
 */
public class ArrayListSorts
{

    /**
     * Constructor for objects of class ArrayListSorts
     */
    public ArrayListSorts()
    {
    }
    
    /**
     * Sorts the list using selection sort
     * @param list ArrayList to be sorted
     */
    public static void selectionSort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++){
            //leastIndex holds the index of the smallest number in arr
            int leastIndex = findSmallest(list, i, list.size() - 1);

            //swaps the next index with the least remaining index
            swap(list, i, leastIndex); 
        }
    }

    /**
     * Sorts the list using radix sort
     * @param list ArrayList to be sorted
     */
    public static void radixSort(ArrayList<Integer> list) {
        //make 10 buckets
        ArrayList<Integer> [] buckets=new ArrayList[10];

        //maxdigits to count the outer loop and pow10 for math to determine a numbers digit
        int maxDigits = getRadixMaxDigits(list);
        int pow10 = 1;
        int bucketNum;
        
        //loop for each digit of the largest number
        for (int totalDigits = 0; totalDigits < maxDigits; totalDigits++) {
            //initialize in here so that the buckets are empty when the loop starts
            for (int i = 0; i < 10; i++){    
                buckets[i] = new ArrayList<Integer>();
            }
            
            //loop to put each number in a bucket
            for (int i = 0; i < list.size(); i++){
                //get the digit and add it to the corresponding bucket
                bucketNum = ((list.get(i) % (pow10 * 10)) / pow10);
                System.out.println(bucketNum);
                buckets[bucketNum].add(list.get(i));
            }
            
            //puts all of the buckets back into one arrayList 
            int arrayCounter = 0;
            for (int i = 0; i < buckets.length; i++){
                for (int j = 0; j < buckets[i].size(); j++){
                    //set each index to new value and adds one to the array position
                    list.set(arrayCounter, buckets[i].get(j));
                    arrayCounter++;
                }
            }
            
            //multiply pow10 by 10 so that the next highest digit is selected on the next loop
            pow10 = pow10 * 10;
        }
    }
    
    // Helper methods
    
    /**
     * Searches list from startIndex up to (but not including) endIndex to
     * find the smallest element
     * @param list arraylist to be searched
     * @param startIndex beginning of range of indices (inclusive)
     * @param endIndex end of range of indices (exclusive)
     * @return index of smallest element in list[startIndex:endIndex-1]
     */
    private static int findSmallest(ArrayList<Integer> list, int startIndex, 
      int endIndex){
          //leastIntIndex holds the least int from the list between startIndex and endIndex
          int leastIntIndex = startIndex;
          
          //loops from startIndex to endIndex
          for(int i = (startIndex + 1); i <= endIndex; i++){
                // if arr index is less than the current least value set leastIntIndex to new least index
                if (list.get(i) < list.get(leastIntIndex)){
                    leastIntIndex = i;
                }
            }
          return leastIntIndex;
      }

    /**
     * Swaps the elements at index i and j in list
     * @param list arraylist of interest
     * @param i index of first element
     * @param j index of second element
     */
    private static void swap(ArrayList<Integer> list, int i, int j){
        //hold index i
        int temp = list.get(i);
        
        //swap i and j
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /**
     * Builds a string representing arraylist list
     * @param list arraylist to be processed
     * @return a string representation of arraylist list as "[ n1 n2 n3 ]"
     */
    public static String getArrayListString(ArrayList<Integer> list) {
        String s = "[";
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size()-1){
                s += list.get(i) + " ";
            } else {
                s += list.get(i);
            }
        }
        s += "]";
        return s;
    }
    
    /**
     * finds the greatest length integer in the list and returns it's length
     * @param list arraylist of interest
     */
    private static int getRadixMaxDigits(ArrayList<Integer> list){
        //find the largest number
        Integer maxNum = list.get(0);
        for (Integer I: list){
            if (I > maxNum){
                maxNum = I;
            }
        }
        
        //how many digits the largest number has
        int mostDigits = maxNum.toString().length();

        return mostDigits;
    }
}
