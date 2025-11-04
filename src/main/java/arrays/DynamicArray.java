package arrays;

import java.util.Arrays;

public class DynamicArray {
    private int[] data;
    private int size;
    private int capacity;

    public DynamicArray() {
        this.capacity = 1;
        this.size = 0;
        this.data = new int[this.capacity];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void resize(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
        capacity = newCapacity;
    }

    public void append(int value) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        data[size++] = value;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = value;
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Array is empty");
        }
        int val = data[size - 1];
        data[size - 1] = 0; // optional
        size--;
        if (size > 0 && size <= capacity / 4) {
            resize(Math.max(1, capacity / 2));
        }
        return val;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }
}
