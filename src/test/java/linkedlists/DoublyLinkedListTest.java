package linkedlists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void testAppendPrepend() {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.append(10);
        dll.append(20);
        dll.prepend(5);
        assertEquals("[5, 10, 20]", dll.toString());
    }

    @Test
    void testInsertAndRemove() {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.append(1); dll.append(3);
        dll.insertAt(1, 2);
        assertEquals("[1, 2, 3]", dll.toString());
        dll.remove(2);
        assertEquals("[1, 3]", dll.toString());
    }
}
