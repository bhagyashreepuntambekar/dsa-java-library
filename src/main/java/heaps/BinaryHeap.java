package heaps;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BinaryHeap {
    private ArrayList<Integer> heap;

    public BinaryHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }

    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0 && heap.get(index) < heap.get(parent(index))) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int extractMin() {
        if (heap.isEmpty()) throw new NoSuchElementException("Heap is empty");

        int root = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return root;
    }

    private void heapifyDown(int index) {
        int n = heap.size();
        while (true) {
            int smallest = index;
            int left = left(index);
            int right = right(index);

            if (left < n && heap.get(left) < heap.get(smallest))
                smallest = left;
            if (right < n && heap.get(right) < heap.get(smallest))
                smallest = right;

            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    public int peek() {
        if (heap.isEmpty()) throw new NoSuchElementException("Heap is empty");
        return heap.get(0);
    }

    public int size() { return heap.size(); }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
