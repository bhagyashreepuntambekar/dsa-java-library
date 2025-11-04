package stacks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackArrayTest {

    @Test
    void testPushPopPeek() {
        StackArray s = new StackArray();
        s.push(10); s.push(20);
        assertEquals(20, s.peek());
        assertEquals(20, s.pop());
        assertEquals(10, s.peek());
    }

    @Test
    void testIsEmptyAndSize() {
        StackArray s = new StackArray();
        assertTrue(s.isEmpty());
        s.push(1);
        assertFalse(s.isEmpty());
        assertEquals(1, s.size());
    }
}
