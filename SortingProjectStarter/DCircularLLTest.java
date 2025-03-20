
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DCircularLLTest.
 *
 * @author  Liz Johnson
 * @version 1/24
 */
public class DCircularLLTest
{
    /**
     * Default constructor for test class DCircularLLTest
     */
    public DCircularLLTest()
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
    public void testConstructor()
    {
        DCircularLL dCircula1 = new DCircularLL();
        assertEquals("Forward: [] Backward: []", dCircula1.toString());
    }

    @Test
    public void testPrepend1()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.prepend(1);
        assertEquals("Forward: [1] Backward: [1]", dCircula1.toString());
    }

    @Test
    public void testPrepend2()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.prepend(1);
        dCircula1.prepend(-1);
        assertEquals("Forward: [-1 1] Backward: [1 -1]", dCircula1.toString());
    }

    @Test
    public void testPrepend3()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.prepend(1);
        dCircula1.prepend(-1);
        dCircula1.prepend(10);
        dCircula1.prepend(5);
        assertEquals("Forward: [5 10 -1 1] Backward: [1 -1 10 5]", 
            dCircula1.toString());
    }

    @Test
    public void testAppend1()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(1);
        assertEquals("Forward: [1] Backward: [1]", dCircula1.toString());
    }

    @Test
    public void testAppend2()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(1);
        dCircula1.append(-1);
        assertEquals("Forward: [1 -1] Backward: [-1 1]", dCircula1.toString());
    }

    @Test
    public void testAppend3()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(1);
        dCircula1.append(-1);
        dCircula1.append(10);
        dCircula1.append(5);
        assertEquals("Forward: [1 -1 10 5] Backward: [5 10 -1 1]", 
            dCircula1.toString());
    }

    @Test
    public void testAppendPrependMix1()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(1);
        dCircula1.prepend(-1);
        dCircula1.prepend(10);
        dCircula1.append(5);
        assertEquals("Forward: [10 -1 1 5] Backward: [5 1 -1 10]", 
            dCircula1.toString());
    }

    @Test
    public void testAppendPrependMix2()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.prepend(-1);
        dCircula1.prepend(10);
        dCircula1.append(5);
        dCircula1.append(1);
        assertEquals("Forward: [10 -1 5 1] Backward: [1 5 -1 10]", 
            dCircula1.toString());
    }

    @Test
    public void testRemoveItem1()
    {
        DCircularLL dCircula1 = new DCircularLL();
        assertEquals(false,dCircula1.remove(1));
        assertEquals("Forward: [] Backward: []", dCircula1.toString());
    }

    @Test
    public void testRemoveItem2()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(11);
        assertEquals(false,dCircula1.remove(1));
        assertEquals("Forward: [11] Backward: [11]", dCircula1.toString());
    }

    @Test
    public void testRemoveItem3()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(11);
        assertEquals(true,dCircula1.remove(11));
        assertEquals("Forward: [] Backward: []", dCircula1.toString());
    }

    @Test
    public void testRemoveItem4()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(-1);
        dCircula1.append(10);
        dCircula1.append(5);
        dCircula1.append(1);

        assertEquals(true,dCircula1.remove(-1));
        assertEquals("Forward: [10 5 1] Backward: [1 5 10]", 
            dCircula1.toString());
    }

    @Test
    public void testRemoveItem5()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(-1);
        dCircula1.append(10);
        dCircula1.append(5);
        dCircula1.append(1);

        assertEquals(true,dCircula1.remove(1));
        assertEquals("Forward: [-1 10 5] Backward: [5 10 -1]", 
            dCircula1.toString());
    }

    @Test
    public void testRemoveItem6()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(-1);
        dCircula1.append(10);
        dCircula1.append(5);
        dCircula1.append(1);

        assertEquals(true,dCircula1.remove(10));
        assertEquals("Forward: [-1 5 1] Backward: [1 5 -1]", 
            dCircula1.toString());
    }

    @Test
    public void testRemoveItem7()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(-1);
        dCircula1.append(10);
        dCircula1.append(5);
        dCircula1.append(1);

        assertEquals(false,dCircula1.remove(50));
        assertEquals("Forward: [-1 10 5 1] Backward: [1 5 10 -1]", 
            dCircula1.toString());
    }

    @Test
    public void testRemoveItem8()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(-1);
        dCircula1.append(10);
        dCircula1.append(5);
        dCircula1.append(1);

        assertEquals(true,dCircula1.remove(10));
        assertEquals(true,dCircula1.remove(1));
        assertEquals("Forward: [-1 5] Backward: [5 -1]", 
            dCircula1.toString());
    }

    @Test
    public void testRemove1()
    {
        DCircularLL dCircula1 = new DCircularLL();
        assertEquals(false,dCircula1.remove());
        assertEquals("Forward: [] Backward: []", dCircula1.toString());
    }

    @Test
    public void testRemove2()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(11);
        assertEquals(true,dCircula1.remove());
        assertEquals("Forward: [] Backward: []", dCircula1.toString());
    }

    @Test
    public void testRemove3()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(11);
        dCircula1.append(12);
        assertEquals(true,dCircula1.remove());
        assertEquals("Forward: [12] Backward: [12]", dCircula1.toString());
    }

    @Test
    public void testRemove4()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(-1);
        dCircula1.append(10);
        dCircula1.append(5);
        dCircula1.append(1);

        assertEquals(true,dCircula1.remove());
        assertEquals("Forward: [10 5 1] Backward: [1 5 10]", 
            dCircula1.toString());
    }

    
    @Test
    public void testRemove5()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(-1);
        dCircula1.append(10);
        dCircula1.append(5);
        dCircula1.append(1);

        assertEquals(true,dCircula1.remove());
        assertEquals(true,dCircula1.remove());
        assertEquals(true,dCircula1.remove());
        assertEquals("Forward: [1] Backward: [1]", 
            dCircula1.toString());
    }

    @Test
    public void testAppendRemoveMix1()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(-1);
        dCircula1.append(10);
        assertEquals(true,dCircula1.remove());
        dCircula1.append(5);
        dCircula1.append(1);
        assertEquals(true,dCircula1.remove());

        assertEquals("Forward: [5 1] Backward: [1 5]", 
            dCircula1.toString());
    }

    @Test
    public void testAppendRemoveItemMix1()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(-1);
        dCircula1.append(10);
        assertEquals(true,dCircula1.remove(10));
        dCircula1.append(5);
        dCircula1.append(1);
        assertEquals(true,dCircula1.remove(5));

        assertEquals("Forward: [-1 1] Backward: [1 -1]", 
            dCircula1.toString());
    }

    @Test
    public void testAppendRemoveItemMix2()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(-1);
        dCircula1.append(10);
        assertEquals(true,dCircula1.remove(10));
        dCircula1.append(5);
        dCircula1.append(1);
        assertEquals(true,dCircula1.remove(5));
        dCircula1.append(50);

        assertEquals("Forward: [-1 1 50] Backward: [50 1 -1]", 
            dCircula1.toString());
    }

    @Test
    public void testIndexOf1()
    {
        DCircularLL dCircula1 = new DCircularLL();
        assertEquals(-1,dCircula1.indexOf(1));
    }

    @Test
    public void testIndexOf2()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(11);
        assertEquals(-1,dCircula1.indexOf(1));
    }

    @Test
    public void testIndexOf3()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(11);
        assertEquals(0,dCircula1.indexOf(11));
    }

    @Test
    public void testIndexOf4()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(-1);
        dCircula1.append(10);
        dCircula1.append(5);
        dCircula1.append(1);

        assertEquals(0,dCircula1.indexOf(-1));
    }

    @Test
    public void testIndexOf5()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(-1);
        dCircula1.append(10);
        dCircula1.append(5);
        dCircula1.append(1);

        assertEquals(3,dCircula1.indexOf(1));

    }

    @Test
    public void testIndexOf6()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(-1);
        dCircula1.append(10);
        dCircula1.append(5);
        dCircula1.append(1);

        assertEquals(1,dCircula1.indexOf(10));
    }

    @Test
    public void testIndexOf7()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(-1);
        dCircula1.append(10);
        dCircula1.append(5);
        dCircula1.append(1);

        assertEquals(-1,dCircula1.indexOf(50));

    }

    @Test
    public void testIndexOf8()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(-1);
        dCircula1.append(10);
        dCircula1.append(5);
        dCircula1.append(1);

        assertEquals(2,dCircula1.indexOf(5));
    }

    @Test
    public void testEmpty1()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.empty();

        assertEquals("Forward: [] Backward: []", 
            dCircula1.toString());
    }

    @Test
    public void testEmpty2()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(1);
        dCircula1.empty();

        assertEquals("Forward: [] Backward: []", 
            dCircula1.toString());
    }

    @Test
    public void testEmpty3()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(1);
        dCircula1.prepend(10);
        dCircula1.empty();

        assertEquals("Forward: [] Backward: []", 
            dCircula1.toString());
    }

    @Test
    public void testEmpty4()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(1);
        dCircula1.prepend(10);
        dCircula1.empty();
        dCircula1.append(100);
        assertEquals("Forward: [100] Backward: [100]", 
            dCircula1.toString());
    }

    @Test
    public void testEmpty5()
    {
        DCircularLL dCircula1 = new DCircularLL();
        dCircula1.append(1);
        dCircula1.prepend(10);
        dCircula1.empty();
        dCircula1.append(100);
        dCircula1.append(300);
        dCircula1.append(500);
        assertEquals("Forward: [100 300 500] Backward: [500 300 100]", 
            dCircula1.toString());
    }
    
    @Test
    public void testMisc1()
    {
        DCircularLL list = new DCircularLL();
        list.append(6);
        list.prepend(9);
        list.append(4);
        list.append(3);
        list.append(2);
        list.prepend(10);
        assertEquals("Forward: [10 9 6 4 3 2] Backward: [2 3 4 6 9 10]", 
            list.toString());
    }
    
    @Test
    public void testMisc2()
    {
        DCircularLL list = new DCircularLL();
        list.append(6);
        list.prepend(9);
        list.append(4);
        list.append(3);
        list.append(2);
        list.prepend(10);
        list.remove(2);
        assertEquals("Forward: [10 9 6 4 3] Backward: [3 4 6 9 10]", 
            list.toString());
    }
    
    @Test
    public void testMisc3()
    {
        DCircularLL list = new DCircularLL();
        list.append(6);
        list.prepend(9);
        list.append(4);
        list.append(3);
        list.append(2);
        list.prepend(10);
        list.remove(2);
        list.remove(10);
        assertEquals("Forward: [9 6 4 3] Backward: [3 4 6 9]", 
            list.toString());
    }
    @Test
    public void testMisc4()
    {
        DCircularLL list = new DCircularLL();
        list.prepend(6);
        list.append(9);
        list.prepend(4);
        list.prepend(3);
        list.prepend(2);
        list.append(10);
        list.remove(2);
        list.remove(10);
        assertEquals("Forward: [3 4 6 9] Backward: [9 6 4 3]", 
            list.toString());
    }
    @Test
    public void testMisc5()
    {
        DCircularLL list = new DCircularLL();
        list.prepend(6);
        list.append(9);
        list.prepend(4);
        list.prepend(3);
        list.prepend(2);
        list.append(10);
        list.remove(2);
        list.remove(10);
        assertEquals("Forward: [3 4 6 9] Backward: [9 6 4 3]", 
            list.toString());
        assertEquals(-1,list.indexOf(2));
    }
    @Test
    public void testMisc6()
    {
        DCircularLL list = new DCircularLL();
        list.prepend(6);
        list.append(9);
        list.prepend(4);
        list.prepend(3);
        list.prepend(2);
        list.append(10);
        list.remove(2);
        list.remove(10);
        assertEquals("Forward: [3 4 6 9] Backward: [9 6 4 3]", 
            list.toString());
        assertEquals(3,list.indexOf(9));
    }
}

