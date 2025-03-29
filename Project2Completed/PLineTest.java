

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PLineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PLineTest
{
    /**
     * Default constructor for test class PLineTest
     */
    public PLineTest()
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
    public void testConstructorAndLineLength()
    {
        PLine p1 = new PLine(5);
        assertEquals(0, p1.getLineLength());
    }
    @Test
    public void testConstructorAndIsEmpty()
    {
        PLine p1 = new PLine(5);
        assertEquals(true, p1.isEmpty());
    }
    @Test
    public void testEnqueueToLimit()
    {
        PLine p1 = new PLine(8);
        for (int i = 0; i < 8; i++) {
            if (!p1.enqueue(new Person(i, i,i*10))) {
                System.out.println("Issue: could not enqueue ("
                        + i + "," + i + ")");
            }
        }
        assertEquals(8, p1.getLineLength());
    }
    @Test
    public void testEnqueueOne()
    {
        PLine p1 = new PLine(10);
        assertEquals(true,p1.enqueue(new Person(5,6,7)));
        assertEquals(1, p1.getLineLength());
    }
    @Test
    public void testEnqueueMoreThanOne()
    {
        PLine p1 = new PLine(15);
        assertEquals(true,p1.enqueue(new Person(5,6,7)));
        assertEquals(true,p1.enqueue(new Person(8,9,10)));
        assertEquals(2, p1.getLineLength());
    }
    @Test
    public void testEnqueueOneOverLimit()
    {
        PLine p1 = new PLine(4);
        for (int i = 0; i < 4; i++) {
            if (!p1.enqueue(new Person(i, i,i*10))) {
                System.out.println("Issue: could not enqueue ("
                        + i + "," + i + ")");
            }
        }
        assertEquals(4, p1.getLineLength());
        assertEquals(false,p1.enqueue(new Person(11,12,13)));
        assertEquals(4, p1.getLineLength());
        
    }
    @Test
    public void testEnqueueTwoOverLimit()
    {
        PLine p1 = new PLine(4);
        for (int i = 0; i < 4; i++) {
            if (!p1.enqueue(new Person(i, i,i*10))) {
                System.out.println("Issue: could not enqueue ("
                        + i + "," + i + ")");
            }
        }
        assertEquals(4, p1.getLineLength());
        assertEquals(false,p1.enqueue(new Person(11,12,13)));
        assertEquals(4, p1.getLineLength());
        assertEquals(false,p1.enqueue(new Person(14,15,16)));
        assertEquals(4, p1.getLineLength());       
    }
    @Test
    public void testEnqueuePeek()
    {
        PLine p1 = new PLine(4);
        for (int i = 0; i < 4; i++) {
            if (!p1.enqueue(new Person(i, i,i*10))) {
                System.out.println("Issue: could not enqueue ("
                        + i + "," + i + ")");
            }
        }
        assertEquals(4, p1.getLineLength());
        assertEquals(new Person(0,0,0),p1.peek());      
    }
    @Test
    public void testEnqueueOneDequeueOne()
    {
        PLine p1 = new PLine(3);
        assertEquals(true,p1.enqueue(new Person(17,18,19)));
        assertEquals(1, p1.getLineLength());
        assertEquals(new Person(17,18,19),p1.dequeue());  
        assertEquals(0, p1.getLineLength());
    }
    @Test
    public void testEnqueueTwoDequeueTwoIsEmpty()
    {
        PLine p1 = new PLine(3);
        assertEquals(true,p1.enqueue(new Person(20,21,22)));
        assertEquals(true,p1.enqueue(new Person(23,24,25)));
        assertEquals(2, p1.getLineLength());
        assertEquals(new Person(20,21,22),p1.dequeue()); 
        assertEquals(new Person(23,24,25),p1.dequeue()); 
        assertEquals(true, p1.isEmpty());
    }
    @Test
    public void testEnqueueTwoPeekDequeueOne()
    {
        PLine p1 = new PLine(3);
        assertEquals(true,p1.enqueue(new Person(20,21,22)));
        assertEquals(true,p1.enqueue(new Person(23,24,25)));
        assertEquals(2, p1.getLineLength());
        assertEquals(new Person(20,21,22),p1.peek()); 
        assertEquals(new Person(20,21,22),p1.dequeue()); 
        assertEquals(1, p1.getLineLength());
    }
    @Test
    public void testDequeueWithEmpty()
    {
        PLine p1 = new PLine(3);       
        assertEquals(null,p1.dequeue());  
        assertEquals(0,p1.getLineLength());      
    }
    @Test
    public void testPeekWithEmpty()
    {
        PLine p1 = new PLine(4);       
        assertEquals(null,p1.peek());        
    }
    @Test
    public void testEnqueueTwoDequeueNegative()
    {
        PLine p1 = new PLine(3);
        assertEquals(true,p1.enqueue(new Person(20,21,22)));
        assertEquals(true,p1.enqueue(new Person(23,24,25)));
        assertEquals(2, p1.getLineLength()); 
        assertEquals(0,p1.dequeue(-20)); 
        assertEquals(2, p1.getLineLength());
    }
    @Test
    public void testEnqueueTwoDequeue_1()
    {
        PLine p1 = new PLine(3);
        assertEquals(true,p1.enqueue(new Person(20,21,22)));
        assertEquals(true,p1.enqueue(new Person(23,24,25)));
        assertEquals(2, p1.getLineLength()); 
        assertEquals(1,p1.dequeue(1)); 
        assertEquals(1, p1.getLineLength());
        assertEquals(new Person(23,24,25),p1.peek()); 
    }
    @Test
    public void testEnqueueTwoDequeue_2()
    {
        PLine p1 = new PLine(3);
        assertEquals(true,p1.enqueue(new Person(20,21,22)));
        assertEquals(true,p1.enqueue(new Person(23,24,25)));
        assertEquals(2, p1.getLineLength()); 
        assertEquals(2,p1.dequeue(2)); 
        assertEquals(0, p1.getLineLength());
        assertEquals(null,p1.peek()); 
    }
    @Test
    public void testEnqueue10dequeue_20()
    {
        PLine p1 = new PLine(20);
        for (int i = 0; i < 10; i++) {
            if (!p1.enqueue(new Person(i, i,i*10))) {
                System.out.println("Issue: could not enqueue ("
                        + i + "," + i + ")");
            }
        }
        assertEquals(10, p1.getLineLength());
        assertEquals(10,p1.dequeue(20)); 
        assertEquals(null,p1.peek());      
    }
    @Test
    public void testEnqueue11dequeue_5()
    {
        PLine p1 = new PLine(20);
        for (int i = 0; i < 11; i++) {
            if (!p1.enqueue(new Person(i, i,i*10))) {
                System.out.println("Issue: could not enqueue ("
                        + i + "," + i + ")");
            }
        }
        assertEquals(11, p1.getLineLength());
        assertEquals(5,p1.dequeue(5)); 
        assertEquals(6, p1.getLineLength());
    }
    @Test
    public void testEnqueue10dequeue_5Enqueue2Peek()
    {
        PLine p1 = new PLine(20);
        for (int i = 0; i < 11; i++) {
            if (!p1.enqueue(new Person(i, i,i*10))) {
                System.out.println("Issue: could not enqueue ("
                        + i + "," + i + ")");
            }
        }
        assertEquals(11, p1.getLineLength());
        assertEquals(5, p1.dequeue(5)); 
        assertEquals(6, p1.getLineLength());
        assertEquals(true,p1.enqueue(new Person(20,21,22)));
        assertEquals(true,p1.enqueue(new Person(23,24,25)));
        assertEquals(new Person(5,5,50),p1.peek());
        assertEquals(8, p1.getLineLength());
    }
}

