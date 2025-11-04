package stacks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackLinkedListTest {

    @Test
    void testPushPopPeek() {
        StackLinkedList s = new StackLinkedList();
        s.push(10); s.push(20);
        assertEquals(20, s.peek());
        s.pop();
        assertEquals(10, s.peek());
    }

    @Test
    void testIsEmptyAndSize() {
        StackLinkedList s = new StackLinkedList();
        assertTrue(s.isEmpty());
        s.push(5);
        assertFalse(s.isEmpty());
        assertEquals(1, s.size());
    }
}
