package cs_and_programming.CS_DESIGN_PATTERNS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SingletonDesignPattern {
    /*
    Only one instance of the cache exists. This is important to make sure that multiple instances don’t interfere with each other when accessing or modifying cache data. You can apply this by making your cache class a singleton.
     */
    private static SingletonDesignPattern instance;
    private final Map<String, Integer> cache;
    private final int capacity;
    private final LinkedList<String> keys;

    private SingletonDesignPattern(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.keys = new LinkedList<>();
    }

    public static SingletonDesignPattern getInstance(int capacity) {
        if (instance == null) {
            instance = new SingletonDesignPattern(capacity);
        }
        return instance;
    }

    public void put(String key, int value) {
        if (cache.size() >= capacity) {
            String oldestKey = keys.removeFirst();
            cache.remove(oldestKey);
        }
        cache.put(key, value);
        keys.addLast(key);
    }

    public Integer get(String key) throws Exception {
        if (!cache.containsKey(key)) {
            throw new Exception(key + "is not in the cache");
        }
        return cache.get(key);
    }

    public void remove(String key) {
        cache.remove(key);
        keys.remove(key);
    }

    public void clear() {
        cache.clear();
        keys.clear();
    }

    public boolean containsKey(String key) {
        return cache.containsKey(key);
    }

    public int size() {
        return cache.size();
    }
}
