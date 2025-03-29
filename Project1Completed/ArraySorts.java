
/**
 * Sorting algorithms for arrays.
 *
 * @author Hayden Gillen
 * @version 1/26
 */
public class ArraySorts
{

    /**
     * Constructor for objects of class ArraySorts
     */
    public ArraySorts()
    {
    }

    /**
     * Sorts arr using selection sort.
     * @param arr array to be sorted
     */
    public static void selectionSort(int[] arr) {
        // your insertion code goes here. Must use swap and findSmallest 
        // (helper methods that you write)   
        for (int i = 0; i < arr.length; i++){
            //leastIndex holds the index of the smallest number in arr
            int leastIndex = findSmallest(arr, i, arr.length - 1);
            
            //swaps the next index with the least remaining index
            swap(arr, i, leastIndex); 
        }
    }

    /**
     * Sorts arr using insertion sort
     * @param list arr to be sorted
     */
    public static void insertionSort(int [] arr) {
        // your insertion code goes here
        //loop to move through each index of the list for the next number to sort
        for (int i = 1; i < arr.length; i++){
            //set j = i so that we can compare to each prior index starting with i
            int j = i;
            //loops through each previous index until the previous item is not less than the number were sorting
            //also terminates when it reaches the beginning of the list
            while (j > 0 && (arr[j] < arr[j - 1])) {
                //calls swap to swap the current index with the one before it
                swap(arr, j, j-1);
                
                //sets the current index were observing to the position it has been moved to
                j--;
            }
            
        }
    }

    // Helper methods
    /**
     * Searches arr from startIndex up to (but not including) endIndex to
     * find the smallest element
     * @param arr array to be searched
     * @param startIndex beginning of range of indices (inclusive)
     * @param endIndex end of range of indices (exclusive)
     * @return index of smallest element in arr[startIndex:endIndex-1]
     */
    private static int findSmallest(int [] arr, int startIndex, 
      int endIndex){
          //leastIntIndex holds the least int from the list between startIndex and endIndex
          int leastIntIndex = startIndex;
          
          //loops from startIndex to endIndex
          for(int i = (startIndex + 1); i <= endIndex; i++){
                // if arr index is less than the current least value set leastIntIndex to new least index
                if (arr[i] < arr[leastIntIndex]){
                    leastIntIndex = i;
                }
            }
          return leastIntIndex;
      }

    /**
     * Swaps the elements at index i and j in arr
     * @param arr array of interest
     * @param i index of first element
     * @param j index of second element
     */
    private static void swap(int [] arr, int i, int j){
        //hold index i
        int temp = arr[i];
        
        //swap i and j
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Builds a string representing array arr
     * @param arr array to be processed
     * @return a string representation of array arr as "[ n1 n2 n3 ]"
     */
    public static String getArrayString(int[] arr) {
        String s = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i!=arr.length-1){
                s += arr[i] + " ";
            }
            else {
                s += arr[i];
            }
        }
        s += "]";
        return s;
    }
}
