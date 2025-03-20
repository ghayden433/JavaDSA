

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * The test class ArrayListSortsTest.
 *
 * @author  Liz Johnson
 * @version 1/24
 */
public class ArrayListSortsTest
{
    /**
     * Default constructor for test class ArrayListSortsTest
     */
    public ArrayListSortsTest()
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
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        ArrayListSorts.selectionSort(list);
        assertEquals("[1]", ArrayListSorts.getArrayListString(list));
    }
    
    @Test
    public void testSelectionSort2()
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        ArrayListSorts.selectionSort(list);
        assertEquals("[1 3 5]", ArrayListSorts.getArrayListString(list));
    }
    
    @Test
    public void testSelectionSort3()
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        ArrayListSorts.selectionSort(list);
        assertEquals("[1 3 5]", ArrayListSorts.getArrayListString(list));
    }
    
    @Test
    public void testSelectionSort4()
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(-40);
        list.add(-20);
        list.add(-2);
        ArrayListSorts.selectionSort(list);
        assertEquals("[-40 -20 -2 1 3 5]", ArrayListSorts.getArrayListString(list));
    }
    
    @Test
    public void testSelectionSort5()
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-5);
        list.add(-3);
        list.add(-1);
        list.add(-40);
        list.add(-20);
        list.add(-2);
        ArrayListSorts.selectionSort(list);
        assertEquals("[-40 -20 -5 -3 -2 -1]", ArrayListSorts.getArrayListString(list));
    }
    
    @Test
    public void testSelectionSort6()
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-5);
        list.add(3);
        list.add(-1);
        list.add(40);
        list.add(-20);
        list.add(2);
        ArrayListSorts.selectionSort(list);
        assertEquals("[-20 -5 -1 2 3 40]", ArrayListSorts.getArrayListString(list));
    }
    
    @Test
    public void testRadixSort1()
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        ArrayListSorts.radixSort(list);
        assertEquals("[1]", ArrayListSorts.getArrayListString(list));
    }
    
    @Test
    public void testRadixSort2()
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        ArrayListSorts.radixSort(list);
        assertEquals("[1 3 5]", ArrayListSorts.getArrayListString(list));
    }
    
    @Test
    public void testRadixSort3()
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        ArrayListSorts.radixSort(list);
        assertEquals("[1 3 5]", ArrayListSorts.getArrayListString(list));
    }
    
    @Test
    public void testRadixSort4()
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(405);
        list.add(504);
        list.add(45);
        ArrayListSorts.radixSort(list);
        assertEquals("[1 3 5 45 405 504]", 
            ArrayListSorts.getArrayListString(list));
    }
    
    @Test
    public void testRadixSort5()
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(89);
        list.add(3);
        list.add(109);
        list.add(9);
        list.add(459);
        list.add(83);
        list.add(543);
        list.add(73);
        list.add(555);
        list.add(523);
        list.add(8);
        ArrayListSorts.radixSort(list);
        assertEquals("[3 8 9 73 83 89 109 459 523 543 555]", 
            ArrayListSorts.getArrayListString(list));
    }
    
    @Test
    public void testRadixSort6()
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(45);
        list.add(30);
        list.add(31);
        list.add(40);
        list.add(20);
        list.add(23);
        ArrayListSorts.radixSort(list);
        assertEquals("[20 23 30 31 40 45]", ArrayListSorts.getArrayListString(list));
    }
    
    @Test
    public void testRadixSort7()
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(895);
        list.add(37);
        list.add(15);
        list.add(40);
        list.add(97);
        list.add(8275);
        list.add(8745);
        ArrayListSorts.radixSort(list);
        assertEquals("[15 37 40 97 895 8275 8745]", 
            ArrayListSorts.getArrayListString(list));
    }
}
