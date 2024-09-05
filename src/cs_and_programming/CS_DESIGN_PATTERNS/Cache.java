package cs_and_programming.CS_DESIGN_PATTERNS;

import java.util.*;

public class Cache {
    //we need a map to store cache key-value pairs
    private Map<String, Integer> cache;
    //we need a linked list to maintain order of insertion (for LRU or FIFO)
    //the first item is the oldest and the last item is the most recent
    private LinkedList<String> keys;
    //we need cache size limit
    private int capacity;

    public Cache(int capacity) {
        this.cache = new HashMap<>();
        this.keys = new LinkedList<>();
        this.capacity = capacity;
    }

    //create a method to add or update a pair in cache
    public void put(String key, int value) {
        if (cache.size() >= capacity) {
            //we want to remove the least used item when cache capacity is full
            String leastUsed = keys.removeFirst(); //Deque method, removes the 1st item
            cache.remove(leastUsed);
        }
        cache.put(key, value); //replace with a new key-value pair
        keys.addLast(key); //Deque method to keep a track of insertion order, adding to the end of the list, means the key was just used
    }

    //create a method to retrieve the value for the given key
    public int get(String key) throws Exception {
        if (!cache.containsKey(key)) {
            throw new Exception(key + "is not in the cache");
        }
        return cache.get(key);
    }

    //create a method to delete a key-value pair
    public void remove(String key) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            keys.remove(key); //need to also remove from List insertion order tracking
        }
    }

    //optional method to clear the cache
    public void clear() {
        cache.clear();
        keys.clear();
    }

    //check the size of current cache
    public int size() {
        return cache.size();
    }

}

}
