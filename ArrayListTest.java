
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest<T> {
    private ArrayList<Integer> list;

    @Before
    public void setUp() {
        list = new ArrayList<Integer>();
    }

    @Test
    public void testConstructor() {
        assertNotNull(list);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.addToBack(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testAddToFront() {
        list.addToFront(1);
        assertEquals(1, (int)list.get(0));
        list.addToFront(2);
        assertEquals(2, (int)list.get(0));
        assertEquals(1, (int)list.get(1));
    }

    @Test
    public void testAddToBack() {
        list.addToBack(1);
        assertEquals(1, (int)list.get(0));
        list.addToBack(2);
        assertEquals(1, (int)list.get(0));
        assertEquals(2, (int)list.get(1));
    }

    @Test
    public void testAddAtIndex() {
        list.addToBack(1);
        list.addToBack(3);
        list.addAtIndex(1, 2);
        assertEquals(1, (int)list.get(0));
        assertEquals(2, (int)list.get(1));
        assertEquals(3, (int)list.get(2));
    }

    @Test
    public void testRemoveFromFront() {
        list.addToBack(1);
        list.addToBack(2);
        list.removeFromFront();
        assertEquals(1, list.size());
        assertEquals(2, (int)list.get(0));
    }

    @Test
    public void testRemoveFromBack() {
        list.addToBack(1);
        list.addToBack(2);
        list.removeFromBack();
        assertEquals(1, list.size());
        assertEquals(1, (int)list.get(0));
    }

    @Test
    public void testRemoveAtIndex() {
        list.addToBack(1);
        list.addToBack(2);
        list.addToBack(3);
        list.removeAtIndex(1);
        assertEquals(2, list.size());
        assertEquals(1, (int)list.get(0));
        assertEquals(3, (int)list.get(1));
    }

    @Test
    public void testClear() {
        list.addToBack(1);
        list.addToBack(2);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testGet() {
        list.addToBack(1);
        list.addToBack(2);
        assertEquals(1, (int)list.get(0));
        assertEquals(2, (int)list.get(1));
    }

    @Test
    public void testGetIndexOutOfBounds() {
        try {
            list.get(0);
            fail("Should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }
}




