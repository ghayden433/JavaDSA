
/**
 * Sorting algorithms for arrays.
 *
 * @author YOUR NAME HERE
 * @version 1/24
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
    }

    /**
     * Sorts arr using insertion sort
     * @param list arr to be sorted
     */
    public static void insertionSort(int [] arr) {
        // your insertion code goes here
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
          return 0;
      }

    /**
     * Swaps the elements at index i and j in arr
     * @param arr array of interest
     * @param i index of first element
     * @param j index of second element
     */
    private static void swap(int [] arr, int i, int j){
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
