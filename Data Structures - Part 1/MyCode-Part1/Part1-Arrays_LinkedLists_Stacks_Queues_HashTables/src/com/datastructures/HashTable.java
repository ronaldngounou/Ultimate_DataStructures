package com.datastructures;

import java.util.LinkedList;

public class HashTable {
    // HashTable
    // put(k, v)
    // get(k): v
    // remove(k)
    // k: int
    // v: string
    // Collisions: chaining
    // LinkedList<Entry>[]
    // [LL, LL, LL, LL, LL]

    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value){
        var index = hash(key);
        if (entries[index]==null)
            entries[index] = new LinkedList<>();

        var bucket = entries[index];
        for (var entry : bucket){
            if (entry.key == key){
                entry.value = value;
                return;}
        }

        bucket.addLast(new Entry(key, value));
        System.out.println("Entry added.");
    }

    public String get(int key){
        var index = hash(key);
        var bucket = entries[index];

        if (bucket != null){
            for (var entry : bucket){
                if (entry.key == key)
                    return entry.value;
            }
        }

        return  null;
    }

    public void remove(int key){
        var index = hash(key);
        var bucket = entries[index];
        if (bucket == null)
            throw new IllegalStateException("Cloud not remove the key in the bucket. Bucket is empty.");
        for (var entry : bucket){
            if (entry.key == key){
                bucket.remove(entry);
                return;
            }
        }
        throw new IllegalStateException("Key not found in the bucket");

    }

    private int hash(int key){
        return key%entries.length;
    }

    /*public static int hash(String key){
        String s = "";
        s.hashCode(); //converts the string into a hash value

        int hash = 0;
        for (var ch: key.toCharArray())
            hash += ch;
        return hash % 100;
        // Store people passwords

        // Hashmaps works by associating an index value to a hashcode by passing it to a hashfunction.
    }*/
}
