package linkedlists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void testAppendPrepend() {
        SinglyLinkedList ll = new SinglyLinkedList();
        ll.append(10);
        ll.append(20);
        ll.prepend(5);
        assertEquals("[5, 10, 20]", ll.toString());
    }

    @Test
    void testInsertAndRemove() {
        SinglyLinkedList ll = new SinglyLinkedList();
        ll.append(1); ll.append(3);
        ll.insertAt(1, 2);
        assertEquals("[1, 2, 3]", ll.toString());
        ll.remove(2);
        assertEquals("[1, 3]", ll.toString());
    }

    @Test
    void testSearch() {
        SinglyLinkedList ll = new SinglyLinkedList();
        ll.append(10); ll.append(20);
        assertEquals(1, ll.search(20));
        assertEquals(-1, ll.search(50));
    }
}
