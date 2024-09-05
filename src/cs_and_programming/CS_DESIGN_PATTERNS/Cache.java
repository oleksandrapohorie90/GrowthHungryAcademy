package cs_and_programming.CS_DESIGN_PATTERNS;

import java.util.*;

public class Cache {
    //we need a map to store cache key-value pairs
    private Map<String, Integer> cache;
    //we need a linked list to maintain order of insertion (for LRU or FIFO)
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
        keys.addLast(key); //Deque method to keep a track of insertion order
    }


}

}
