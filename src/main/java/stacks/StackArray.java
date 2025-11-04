package stacks;

import java.util.ArrayList;

public class StackArray {
    private ArrayList<Integer> items;

    public StackArray() { items = new ArrayList<>(); }

    public boolean isEmpty() { return items.isEmpty(); }
    public void push(int data) { items.add(data); }
    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return items.remove(items.size() - 1);
    }
    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return items.get(items.size() - 1);
    }
    public int size() { return items.size(); }

    @Override
    public String toString() { return items.toString(); }

    public static void main(String[] args) {
        StackArray s = new StackArray();
        s.push(10); s.push(20); s.push(30);
        System.out.println(s); // [10, 20, 30]
        s.pop();
        System.out.println(s); // [10, 20]
    }
}
