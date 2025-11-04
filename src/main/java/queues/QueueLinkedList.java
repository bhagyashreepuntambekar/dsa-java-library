package queues;

import linkedlists.SinglyLinkedList;

public class QueueLinkedList {
    private SinglyLinkedList list;

    public QueueLinkedList() { list = new SinglyLinkedList(); }

    public boolean isEmpty() { return list.isEmpty(); }

    public void enqueue(int data) { list.append(data); }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        // get head
        int val = Integer.parseInt(list.toString().replaceAll("[\\[\\] ]", "").split(",")[0]);
        list.remove(val);
        return val;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return Integer.parseInt(list.toString().replaceAll("[\\[\\] ]", "").split(",")[0]);
    }

    public int size() { return list.size(); }

    public static void main(String[] args) {
        QueueLinkedList q = new QueueLinkedList();
        q.enqueue(10); q.enqueue(20); q.enqueue(30);
        System.out.println(q.dequeue()); // 10
        System.out.println(q.peek());    // 20
    }
}
