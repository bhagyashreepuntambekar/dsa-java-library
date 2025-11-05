package hashtable;

import java.util.LinkedList;
import java.util.Objects;

public class HashTable<K,V> {

    private static class Entry<K,V>{
        K key;
        V value;

        Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry<K,V>>[] buckets;
    private int capacity;
    private int size;
    private static final double LOAD_FACTOR = 0.7;

    public HashTable(int capacity){
        this.capacity = capacity;
        this.size = 0;
        buckets = new LinkedList[capacity];
        for(int i=0; i<capacity;i++){
            buckets[i] = new LinkedList<>();
        }
    }

    public HashTable(){
        this(10);
    }

    private int hash(K key){
        return Math.abs(Objects.hashCode(key)) % capacity;
    }

    private void resize(){
        LinkedList<Entry<K, V>>[] oldBuckets = buckets;
        capacity *= 2;
        buckets = new LinkedList[capacity];
        size = 0;

        for(int i = 0; i<capacity; i++){
            buckets[i] = new LinkedList<>();
        }

        for (LinkedList<Entry<K, V>> bucket:oldBuckets){
            for(Entry<K,V> entry:bucket){
                put(entry.key, entry.value);
            }
        }
    }

    public void put(K key,V value){
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K,V> entry: bucket){
            if(entry.key.equals(key)){
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
        size++;

        if(size/capacity > LOAD_FACTOR){
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    public boolean remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return true;
            }
        }

        return false;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;

        for (LinkedList<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> entry : bucket) {
                if (!first) sb.append(", ");
                sb.append(entry.key).append(": ").append(entry.value);
                first = false;
            }
        }

        sb.append("}");
        return sb.toString();
    }
}
