package linkedlists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CircularLinkedListTest {

    @Test
    void testAppendPrepend() {
        CircularLinkedList cll = new CircularLinkedList();
        cll.append(10); cll.append(20); cll.prepend(5);
        assertEquals("[5, 10, 20]", cll.toString());
    }

    @Test
    void testRemove() {
        CircularLinkedList cll = new CircularLinkedList();
        cll.append(1); cll.append(2); cll.append(3);
        cll.remove(2);
        assertEquals("[1, 3]", cll.toString());
    }
}
