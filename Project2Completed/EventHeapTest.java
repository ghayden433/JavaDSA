

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * The test class EventHeapTest.
 *
 * @author  Liz
 * @version 2/19/24
 */
public class EventHeapTest
{
    /**
     * Default constructor for test class EventHeapTest
     */
    public EventHeapTest()
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
    public void testConstructorSizeIsEmpty()
    {
        EventHeap eventHea1 = new EventHeap(200);
        assertEquals(0, eventHea1.size());
        assertEquals(true,eventHea1.isEmpty());
    }
    @Test
    public void testAddOneEmptySize(){
        EventHeap e1 = new EventHeap(200);
        Person p = new Person(0, 0,0);
        assertEquals(true,e1.add(new Event(EventType.START_RIDE, 501, p)));
        assertEquals(false,e1.isEmpty());
        assertEquals(1, e1.size());
    }
    @Test
    public void testConstructorPeek()
    {
        EventHeap eventHea1 = new EventHeap(200);
        assertEquals(0, eventHea1.size());
        assertEquals(null,eventHea1.peek());
    }
    @Test
    public void testConstructorRemove()
    {
        EventHeap eventHea1 = new EventHeap(200);
        assertEquals(0, eventHea1.size());
        assertEquals(null,eventHea1.remove());
    }
    @Test
    public void testAddPeek(){
        EventHeap e1 = new EventHeap(100);
        Person p = new Person(0, 0,0);
        assertEquals(true,e1.add(new Event(EventType.START_RIDE, 501, p)));
        assertEquals(new Event(EventType.START_RIDE, 501, p),e1.peek());
    }
    @Test
    public void testAddPeekRemove(){
        EventHeap e1 = new EventHeap(100);
        Person p = new Person(0, 0,0);
        assertEquals(true,e1.add(new Event(EventType.START_RIDE, 11, p)));
        assertEquals(new Event(EventType.START_RIDE, 11, p),e1.peek());
        assertEquals(true,e1.add(new Event(EventType.START_RIDE, 10, p)));
        assertEquals(new Event(EventType.START_RIDE, 10, p),e1.peek());
        assertEquals(new Event(EventType.START_RIDE, 10, p),e1.remove());
        assertEquals(new Event(EventType.START_RIDE, 11, p),e1.peek());
    }
    @Test
    public void testAddSeveralRemove(){
        EventHeap e1 = new EventHeap(100);
        Person p = new Person(0, 0,0);
        assertEquals(true,e1.add(new Event(EventType.END_RIDE, 11, p)));
        assertEquals(true,e1.add(new Event(EventType.END_RIDE, 10, p)));
        assertEquals(true,e1.add(new Event(EventType.END_RIDE, 5, p)));
        assertEquals(true,e1.add(new Event(EventType.END_RIDE, 9, p)));
        assertEquals(true,e1.add(new Event(EventType.END_RIDE, 3, p)));
        assertEquals(true,e1.add(new Event(EventType.END_RIDE, 1, p)));
        assertEquals(true,e1.add(new Event(EventType.END_RIDE, 15, p)));
        assertEquals(new Event(EventType.END_RIDE, 1, p),e1.remove());
        assertEquals(new Event(EventType.END_RIDE, 3, p),e1.remove());
        assertEquals(new Event(EventType.END_RIDE, 5, p),e1.remove());
        assertEquals(new Event(EventType.END_RIDE, 9, p),e1.remove());
        assertEquals(new Event(EventType.END_RIDE, 10, p),e1.remove());
        assertEquals(new Event(EventType.END_RIDE, 11, p),e1.remove());
        assertEquals(new Event(EventType.END_RIDE, 15, p),e1.remove());
        assertEquals(null,e1.remove());
    }
    @Test
    public void testAddManyRemove(){
        EventHeap e1 = new EventHeap(100);
        Person p = new Person(0, 0,0);
        for(int i=0; i < 100; i++){
            e1.add(new Event(EventType.ARRIVE_AT_CARNIVAL, (200-i), p));
        }
        assertEquals(true,e1.add(new Event(EventType.END_RIDE, 5, p)));
        assertEquals(true,e1.add(new Event(EventType.END_RIDE, 3, p)));
        assertEquals(102,e1.size());
        assertEquals(new Event(EventType.END_RIDE, 3, p),e1.remove());
        assertEquals(new Event(EventType.END_RIDE, 5, p),e1.remove());
        assertEquals(new Event(EventType.ARRIVE_AT_CARNIVAL, 101, p),e1.remove());
    }
    @Test
    public void testAddThreeCheckResize(){
        EventHeap e1 = new EventHeap(2);
        Person p = new Person(0, 0,0);
        
        assertEquals(true,e1.add(new Event(EventType.END_RIDE, 5, p)));
        assertEquals(true,e1.add(new Event(EventType.END_RIDE, 3, p)));
        assertEquals(2,e1.size());
        assertEquals(true,e1.add(new Event(EventType.END_RIDE, 2, p)));
        assertEquals(3,e1.size());
    }
    @Test
    public void testAdd5RemoveNeg(){
        EventHeap e1 = new EventHeap(100);
        Person p = new Person(0, 0,0);
        for(int i=0; i < 5; i++){
            e1.add(new Event(EventType.ARRIVE_AT_CARNIVAL, (200-i), p));
        }
        assertEquals(5,e1.size());
        ArrayList<Event> list=e1.remove(-80);
        assertEquals(0,list.size());
    }
    @Test
    public void testEmptyTryToRemoveOne(){
        EventHeap e1 = new EventHeap(100);
        
        assertEquals(0,e1.size());
        ArrayList<Event> list=e1.remove(1);
        assertEquals(0,list.size());
    }
    @Test
    public void testAdd5Remove4(){
        EventHeap e1 = new EventHeap(100);
        Person p = new Person(0, 0,0);
        for(int i=0; i < 5; i++){
            e1.add(new Event(EventType.ARRIVE_AT_CARNIVAL, (200-i), p));
        }
        assertEquals(5,e1.size());
        ArrayList<Event> list = e1.remove(4);
        assertEquals(4,list.size());
        assertEquals(new Event(EventType.ARRIVE_AT_CARNIVAL, 196, p),list.get(0));
        assertEquals(new Event(EventType.ARRIVE_AT_CARNIVAL, 197, p),list.get(1));
        assertEquals(new Event(EventType.ARRIVE_AT_CARNIVAL, 198, p),list.get(2));
        assertEquals(new Event(EventType.ARRIVE_AT_CARNIVAL, 199, p),list.get(3));
        assertEquals(new Event(EventType.ARRIVE_AT_CARNIVAL, 200, p),e1.remove());
    }
    @Test
    public void testAdd5Remove5(){
        EventHeap e1 = new EventHeap(100);
        Person p = new Person(0, 0,0);
        for(int i=0; i < 5; i++){
            e1.add(new Event(EventType.ARRIVE_AT_CARNIVAL, (200-i), p));
        }
        assertEquals(5,e1.size());
        ArrayList<Event> list = e1.remove(5);
        assertEquals(5,list.size());
        assertEquals(new Event(EventType.ARRIVE_AT_CARNIVAL, 196, p),list.get(0));
        assertEquals(new Event(EventType.ARRIVE_AT_CARNIVAL, 197, p),list.get(1));
        assertEquals(new Event(EventType.ARRIVE_AT_CARNIVAL, 198, p),list.get(2));
        assertEquals(new Event(EventType.ARRIVE_AT_CARNIVAL, 199, p),list.get(3));
        assertEquals(new Event(EventType.ARRIVE_AT_CARNIVAL, 200, p),list.get(4));
        assertEquals(null,e1.remove());
    }
    @Test
    public void testAdd5TryRemove10(){
        EventHeap e1 = new EventHeap(100);
        Person p = new Person(0, 0,0);
        for(int i=0; i < 5; i++){
            e1.add(new Event(EventType.ARRIVE_AT_CARNIVAL, (200-i), p));
        }
        assertEquals(5,e1.size());
        ArrayList<Event> list = e1.remove(10);
        assertEquals(5,list.size());
        assertEquals(new Event(EventType.ARRIVE_AT_CARNIVAL, 196, p),list.get(0));
        assertEquals(new Event(EventType.ARRIVE_AT_CARNIVAL, 197, p),list.get(1));
        assertEquals(new Event(EventType.ARRIVE_AT_CARNIVAL, 198, p),list.get(2));
        assertEquals(new Event(EventType.ARRIVE_AT_CARNIVAL, 199, p),list.get(3));
        assertEquals(new Event(EventType.ARRIVE_AT_CARNIVAL, 200, p),list.get(4));
        
        assertEquals(null,e1.remove());
    }
}

