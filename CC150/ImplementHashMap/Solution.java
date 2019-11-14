package com.CC150.SwapNodesinPairs;

public class Entry<K, V> {
    public K key;
    public V value;
    public Entry<K, V> next;
    public Entry(K key, V value, Entry<K,V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}


public class HashMap<K,V> {
    private Entry<K,V>[] buckets;
    private static final int INITIAL_CAPACITY = 16;
    private int size;
    private int capacity;

    public HashMap(){
        this(INITIAL_CAPACITY);
    }

    public HashMap(int capacity){
        this.buckets = new Entry[capacity];
        this.capacity = capacity;
    }
    //put function
    public void put(K key, V value) {
        Entry<K,V> node = new Entry<>(key, value, null);
        int index = getBucketIndex(key);
        Entry<K, V> entry = buckets[index];
        if (entry == null){
            buckets[index] = node;
            return;
        }
        while(entry.next != null){
            if (entry.key == key){
                entry.value = value;
                return;
            }
            entry = entry.next;
        }
        if (entry.key == key){
            entry.value = value;
            return;
        }
        entry.next = node;
    }

    // get function
    public V get(K key){
        int index = getBucketIndex(key);
        Entry<K, V> entry = buckets[index];
        if (entry == null){
            return null;
        }
        while(entry != null){
            if (entry.key == key){
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    private int getBucketIndex(K key){
        int hash = Math.abs(key.hashCode());
        return hash % capacity;
    }

    public int size(){
        return size;
    }
}
