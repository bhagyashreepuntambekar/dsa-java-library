package linkedlists;

public class SinglyLinkedList {
    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() { head = null; size = 0; }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) head = newNode;
        else {
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = newNode;
        }
        size++;
    }

    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertAt(int index, int data) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) { prepend(data); return; }

        Node newNode = new Node(data);
        Node curr = head;
        for (int i = 0; i < index - 1; i++) curr = curr.next;
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    public void remove(int data) {
        if (head == null) throw new RuntimeException("List is empty");
        if (head.data == data) { head = head.next; size--; return; }

        Node curr = head, prev = null;
        while (curr != null && curr.data != data) {
            prev = curr; curr = curr.next;
        }
        if (curr == null) throw new RuntimeException("Data not found");
        prev.next = curr.next;
        size--;
    }

    public int search(int data) {
        Node curr = head; int index = 0;
        while (curr != null) {
            if (curr.data == data) return index;
            curr = curr.next; index++;
        }
        return -1;
    }

    public int removeHead() {
        if (head == null) throw new RuntimeException("List is empty");
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int peekHead() {
        if (head == null) throw new RuntimeException("List is empty");
        return head.data;
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
        SinglyLinkedList ll = new SinglyLinkedList();
        ll.append(10);
        ll.append(20);
        ll.prepend(5);
        System.out.println(ll); // [5, 10, 20]
        ll.remove(10);
        System.out.println(ll); // [5, 20]
    }
}
