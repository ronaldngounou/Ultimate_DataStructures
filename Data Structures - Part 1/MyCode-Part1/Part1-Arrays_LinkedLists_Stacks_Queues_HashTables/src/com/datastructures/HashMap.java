package com.datastructures;

public class HashMap {
    // Build a hash table from scratch. Use linear probing strategy for handling collisions.
    // put(int, String)

    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] entries = new Entry[5];
    private int count;



}
