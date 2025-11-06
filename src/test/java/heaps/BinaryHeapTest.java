package heaps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

public class BinaryHeapTest {

    @Test
    void testInsertAndPeek() {
        BinaryHeap heap = new BinaryHeap();
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        assertEquals(1, heap.peek());
        assertEquals(4, heap.size());
    }

    @Test
    void testExtractMin() {
        BinaryHeap heap = new BinaryHeap();
        int[] values = {5, 3, 8, 1, 2};
        for (int v : values) heap.insert(v);

        int[] expected = {1, 2, 3, 5, 8};
        for (int e : expected) {
            assertEquals(e, heap.extractMin());
        }
        assertEquals(0, heap.size());
    }

    @Test
    void testExtractFromEmpty() {
        BinaryHeap heap = new BinaryHeap();
        assertThrows(NoSuchElementException.class, heap::extractMin);
    }
}
