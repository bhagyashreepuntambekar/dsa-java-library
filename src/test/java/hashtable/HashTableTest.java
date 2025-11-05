package hashtable;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    private HashTable<String, Object> table;

    @BeforeEach
    void setup() {
        table = new HashTable<>();
    }

    @Test
    void testPutAndGet() {
        table.put("name", "Alice");
        table.put("age", 25);

        assertEquals("Alice", table.get("name"));
        assertEquals(25, table.get("age"));
        assertNull(table.get("missing"));
    }

    @Test
    void testUpdateExistingKey() {
        table.put("age", 25);
        table.put("age", 26);

        assertEquals(26, table.get("age"));
        assertEquals(1, table.size());
    }

    @Test
    void testRemoveKey() {
        table.put("country", "Canada");
        assertTrue(table.remove("country"));
        assertNull(table.get("country"));
        assertFalse(table.remove("country"));
    }

    @Test
    void testCollisionHandling() {
        // Force collisions by small capacity
        HashTable<String, String> smallTable = new HashTable<>(2);
        smallTable.put("key1", "A");
        smallTable.put("key2", "B");
        smallTable.put("key3", "C");

        assertEquals("A", smallTable.get("key1"));
        assertEquals("B", smallTable.get("key2"));
        assertEquals("C", smallTable.get("key3"));
        assertEquals(3, smallTable.size());
    }

    @Test
    void testResizeTriggered() {
        HashTable<String, Integer> ht = new HashTable<>(4);
        for (int i = 0; i < 10; i++) {
            ht.put("k" + i, i);
        }

        assertTrue(ht.capacity() >= 8);
        assertEquals(10, ht.size());

        for (int i = 0; i < 10; i++) {
            assertEquals(i, ht.get("k" + i));
        }
    }
}
