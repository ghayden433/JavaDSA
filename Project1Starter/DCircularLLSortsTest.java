
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DCircularLLSortsTest.
 *
 * @author  Liz Johnson
 * @version 1/24
 */
public class DCircularLLSortsTest
{
    /**
     * Default constructor for test class DCircularLLSortsTest
     */
    public DCircularLLSortsTest()
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
    public void testInsertionSort1()
    {
        DCircularLL list = new DCircularLL();
        list.append(1);
        DCircularLLSorts.insertionSort(list);
        assertEquals("Forward: [1] Backward: [1]", list.toString());
    }

    @Test
    public void testInsertionSort2()
    {
        DCircularLL list = new DCircularLL();
        list.append(1);
        list.append(3);
        list.append(5);
        DCircularLLSorts.insertionSort(list);
        assertEquals("Forward: [1 3 5] Backward: [5 3 1]",list.toString());
    }

    @Test
    public void testInsertionSort3()
    {
        DCircularLL list = new DCircularLL();
        list.append(5);
        list.append(3);
        list.append(1);
        DCircularLLSorts.insertionSort(list);
        assertEquals("Forward: [1 3 5] Backward: [5 3 1]", list.toString());
    }

    @Test
    public void testInsertionSort4()
    {
        DCircularLL list = new DCircularLL();
        list.append(5);
        list.append(3);
        list.append(1);
        list.append(-40);
        list.append(-20);
        list.append(-2);
        DCircularLLSorts.insertionSort(list);
        assertEquals("Forward: [-40 -20 -2 1 3 5] Backward: [5 3 1 -2 -20 -40]",
            list.toString());
    }

    @Test
    public void testInsertionSort5()
    {
        DCircularLL list = new DCircularLL();
        list.append(-5);
        list.append(-3);
        list.append(-1);
        list.append(-40);
        list.append(-20);
        list.append(-2);
        DCircularLLSorts.insertionSort(list);
        assertEquals("Forward: [-40 -20 -5 -3 -2 -1] Backward: [-1 -2 -3 -5 -20 -40]",
            list.toString());
    }

    @Test
    public void testInsertionSort6()
    {
        DCircularLL list = new DCircularLL();
        list.append(-5);
        list.append(3);
        list.append(-1);
        list.append(40);
        list.append(-20);
        list.append(2);
        DCircularLLSorts.insertionSort(list);
        assertEquals("Forward: [-20 -5 -1 2 3 40] Backward: [40 3 2 -1 -5 -20]"
        , list.toString());
    }

    @Test
    public void testRadixSort1()
    {
        DCircularLL list = new DCircularLL();
        list.append(1);
        DCircularLLSorts.radixSort(list);
        assertEquals("Forward: [1] Backward: [1]", list);
    }

    @Test
    public void testRadixSort2()
    {
        DCircularLL list = new DCircularLL();
        list.append(1);
        list.append(3);
        list.append(5);
        DCircularLLSorts.radixSort(list);
        assertEquals("Forward: [1 3 5] Backward: [5 3 1]", list);
    }

    @Test
    public void testRadixSort3()
    {
        DCircularLL list = new DCircularLL();
        list.append(5);
        list.append(3);
        list.append(1);
        DCircularLLSorts.radixSort(list);
        assertEquals("Forward: [1 3 5] Backward: [5 3 1]", list);
    }

    @Test
    public void testRadixSort4()
    {
        DCircularLL list = new DCircularLL();
        list.append(5);
        list.append(3);
        list.append(1);
        list.append(405);
        list.append(504);
        list.append(45);
        DCircularLLSorts.radixSort(list);
        assertEquals("Forward: [1 3 5 45 405 504] Backward: [504 405 45 5 3 1]", list);

    }

    @Test
    public void testRadixSort5()
    {
        DCircularLL list = new DCircularLL();
        list.append(89);
        list.append(3);
        list.append(109);
        list.append(9);
        list.append(459);
        list.append(83);
        list.append(543);
        list.append(73);
        list.append(555);
        list.append(523);
        list.append(8);
        DCircularLLSorts.radixSort(list);
        assertEquals("Forward: [3 8 9 73 83 89 109 459 523 543 555] "+
            "Backward: [555 543 523 459 109 89 83 73 9 8 3]",
            list);
    }

    @Test
    public void testRadixSort6()
    {
        DCircularLL list = new DCircularLL();
        list.append(45);
        list.append(30);
        list.append(31);
        list.append(40);
        list.append(20);
        list.append(23);
        DCircularLLSorts.radixSort(list);
        assertEquals("Forward: [20 23 30 31 40 45] "+
            "Backward: [45 40 31 30 23 20]", list);
    }

    @Test
    public void testRadixSort7()
    {
        DCircularLL list = new DCircularLL();
        list.append(895);
        list.append(37);
        list.append(15);
        list.append(40);
        list.append(97);
        list.append(8275);
        list.append(8745);
        DCircularLLSorts.radixSort(list);
        assertEquals("Forward: [15 37 40 97 895 8275 8745] "+
            "Backward: [8745 8275 895 97 40 37 15]", 
            list);
    }
}
