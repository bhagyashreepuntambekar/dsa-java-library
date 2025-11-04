package queues;

import java.util.LinkedList;

public class QueueArray {
    private LinkedList<Integer> items;

    public QueueArray() { items = new LinkedList<>(); }

    public boolean isEmpty() { return items.isEmpty(); }
    public void enqueue(int data) { items.addLast(data); }
    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return items.removeFirst();
    }
    public int peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return items.getFirst();
    }
    public int size() { return items.size(); }

    public static void main(String[] args) {
        QueueArray q = new QueueArray();
        q.enqueue(10); q.enqueue(20); q.enqueue(30);
        System.out.println(q.dequeue()); // 10
        System.out.println(q.peek());    // 20
    }
}
