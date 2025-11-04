package arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    @Test
    void testAppendAndRemove() {
        DynamicArray arr = new DynamicArray();
        arr.append(10);
        arr.append(20);
        arr.append(30);
        assertEquals(3, arr.size());
        assertEquals(30, arr.get(2));
        arr.removeLast();
        assertEquals(2, arr.size());
        assertEquals(20, arr.get(1));
    }

    @Test
    void testSetAndGet() {
        DynamicArray arr = new DynamicArray();
        arr.append(5);
        arr.set(0, 10);
        assertEquals(10, arr.get(0));
    }

    @Test
    void testIsEmpty() {
        DynamicArray arr = new DynamicArray();
        assertTrue(arr.isEmpty());
        arr.append(1);
        assertFalse(arr.isEmpty());
    }
}
