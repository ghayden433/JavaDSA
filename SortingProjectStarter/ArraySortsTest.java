

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ArraySortsTest.
 *
 * @author  Liz Johnson
 * @version 1/24
 */
public class ArraySortsTest
{
    /**
     * Default constructor for test class ArraySortsTest
     */
    public ArraySortsTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testSelectionSort1()
    {
        int[] arr = {1};
        ArraySorts.selectionSort(arr);
        assertEquals("[1]", ArraySorts.getArrayString(arr));
    }
    
    @Test
    public void testSelectionSort2()
    {
        int[] arr = {1,3,5};
        ArraySorts.selectionSort(arr);
        assertEquals("[1 3 5]", ArraySorts.getArrayString(arr));
    }
    
    @Test
    public void testSelectionSort3()
    {
        int[] arr = {5,3,1};
        ArraySorts.selectionSort(arr);
        assertEquals("[1 3 5]", ArraySorts.getArrayString(arr));
    }
    
    @Test
    public void testSelectionSort4()
    {
        int[] arr = {5,3,1,-40, -20, -2};
        ArraySorts.selectionSort(arr);
        assertEquals("[-40 -20 -2 1 3 5]", ArraySorts.getArrayString(arr));
    }
    
    @Test
    public void testSelectionSort5()
    {
        int[] arr = {-5,-3,-1,-40, -20, -2};
        ArraySorts.selectionSort(arr);
        assertEquals("[-40 -20 -5 -3 -2 -1]", ArraySorts.getArrayString(arr));
    }
    
    @Test
    public void testSelectionSort6()
    {
        int[] arr = {-5,3,-1,40, -20, 2};
        ArraySorts.selectionSort(arr);
        assertEquals("[-20 -5 -1 2 3 40]", ArraySorts.getArrayString(arr));
    }
    
    @Test
    public void testInsertionSort1()
    {
        int[] arr = {1};
        ArraySorts.insertionSort(arr);
        assertEquals("[1]", ArraySorts.getArrayString(arr));
    }
    
    @Test
    public void testInsertionSort2()
    {
        int[] arr = {1,3,5};
        ArraySorts.insertionSort(arr);
        assertEquals("[1 3 5]", ArraySorts.getArrayString(arr));
    }
    
    @Test
    public void testInsertionSort3()
    {
        int[] arr = {5,3,1};
        ArraySorts.insertionSort(arr);
        assertEquals("[1 3 5]", ArraySorts.getArrayString(arr));
    }
    
    @Test
    public void testInsertionSort4()
    {
        int[] arr = {5,3,1,-40, -20, -2};
        ArraySorts.insertionSort(arr);
        assertEquals("[-40 -20 -2 1 3 5]", ArraySorts.getArrayString(arr));
    }
    
    @Test
    public void testInsertionSort5()
    {
        int[] arr = {-5,-3,-1,-40, -20, -2};
        ArraySorts.insertionSort(arr);
        assertEquals("[-40 -20 -5 -3 -2 -1]", ArraySorts.getArrayString(arr));
    }
    
    @Test
    public void testInsertionSort6()
    {
        int[] arr = {-5,3,-1,40, -20, 2};
        ArraySorts.insertionSort(arr);
        assertEquals("[-20 -5 -1 2 3 40]", ArraySorts.getArrayString(arr));
    }
}

