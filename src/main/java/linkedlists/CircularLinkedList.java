package linkedlists;

public class CircularLinkedList {
    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head, tail;
    private int size;

    public CircularLinkedList() { head = tail = null; size = 0; }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) { head = tail = newNode; newNode.next = newNode; }
        else { tail.next = newNode; newNode.next = head; tail = newNode; }
        size++;
    }

    public void prepend(int data) {
        Node newNode = new Node(data);
        if (head == null) { head = tail = newNode; newNode.next = newNode; }
        else { newNode.next = head; head = newNode; tail.next = head; }
        size++;
    }

    public void remove(int data) {
        if (head == null) throw new RuntimeException("List is empty");

        Node curr = head, prev = tail;
        boolean found = false;
        do {
            if (curr.data == data) { found = true; break; }
            prev = curr; curr = curr.next;
        } while (curr != head);

        if (!found) throw new RuntimeException("Data not found");

        if (curr == head) { head = head.next; tail.next = head; }
        else if (curr == tail) { tail = prev; tail.next = head; }
        else { prev.next = curr.next; }

        size--;
        if (size == 0) head = tail = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (head == null) return sb.append("]").toString();

        Node curr = head;
        do {
            sb.append(curr.data);
            curr = curr.next;
            if (curr != head) sb.append(", ");
        } while (curr != head);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.append(10); cll.append(20); cll.prepend(5);
        System.out.println(cll); // [5, 10, 20]
        cll.remove(10);
        System.out.println(cll); // [5, 20]
    }
}
