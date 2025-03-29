import java.util.ArrayList;

/**
 * Sorting algorithms for ArrayLists.
 *
 * @author YOUR NAME HERE
 * @version 1/24
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
        
    }

    /**
     * Sorts the list using radix sort
     * @param list ArrayList to be sorted
     */
    public static void radixSort(ArrayList<Integer> list) {
        
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
          return 0;
      }

    /**
     * Swaps the elements at index i and j in list
     * @param list arraylist of interest
     * @param i index of first element
     * @param j index of second element
     */
    private static void swap(ArrayList<Integer> list, int i, int j){
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
}
