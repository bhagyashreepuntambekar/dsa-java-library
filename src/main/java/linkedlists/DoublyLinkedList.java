package linkedlists;

public class DoublyLinkedList {
    private static class Node {
        int data;
        Node next, prev;
        Node(int data) { this.data = data; }
    }

    private Node head, tail;
    private int size;

    public DoublyLinkedList() { head = tail = null; size = 0; }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) { head = tail = newNode; }
        else { tail.next = newNode; newNode.prev = tail; tail = newNode; }
        size++;
    }

    public void prepend(int data) {
        Node newNode = new Node(data);
        if (head == null) { head = tail = newNode; }
        else { newNode.next = head; head.prev = newNode; head = newNode; }
        size++;
    }

    public void insertAt(int index, int data) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) { prepend(data); return; }
        if (index == size) { append(data); return; }

        Node newNode = new Node(data);
        Node curr = head;
        for (int i = 0; i < index - 1; i++) curr = curr.next;
        newNode.next = curr.next;
        newNode.prev = curr;
        curr.next.prev = newNode;
        curr.next = newNode;
        size++;
    }

    public void remove(int data) {
        if (head == null) throw new RuntimeException("List is empty");

        Node curr = head;
        while (curr != null && curr.data != data) curr = curr.next;
        if (curr == null) throw new RuntimeException("Data not found");

        if (curr.prev != null) curr.prev.next = curr.next;
        else head = curr.next;

        if (curr.next != null) curr.next.prev = curr.prev;
        else tail = curr.prev;
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node curr = head;
        while (curr != null) {
            sb.append(curr.data);
            if (curr.next != null) sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.append(10); dll.append(20); dll.prepend(5);
        System.out.println(dll); // [5, 10, 20]
        dll.remove(10);
        System.out.println(dll); // [5, 20]
    }
}
