package stacks;

import linkedlists.SinglyLinkedList;

public class StackLinkedList {
    private SinglyLinkedList list;

    public StackLinkedList() {
        list = new SinglyLinkedList();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(int data) {
        list.prepend(data);  // push to head
    }

    public int pop() {
        return list.removeHead();  // remove head safely
    }

    public int peek() {
        return list.peekHead();    // peek head safely
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        StackLinkedList s = new StackLinkedList();
        s.push(10); s.push(20); s.push(30);
        System.out.println(s);  // [30, 20, 10]
        System.out.println(s.pop()); // 30
        System.out.println(s.peek()); // 20
    }
}
