package queues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueLinkedListTest {

    @Test
    void testEnqueueDequeuePeek() {
        QueueLinkedList q = new QueueLinkedList();
        q.enqueue(10); q.enqueue(20);
        assertEquals(10, q.peek());
        assertEquals(10, q.dequeue());
        assertEquals(20, q.peek());
    }

    @Test
    void testIsEmptyAndSize() {
        QueueLinkedList q = new QueueLinkedList();
        assertTrue(q.isEmpty());
        q.enqueue(5);
        assertFalse(q.isEmpty());
        assertEquals(1, q.size());
    }
}
