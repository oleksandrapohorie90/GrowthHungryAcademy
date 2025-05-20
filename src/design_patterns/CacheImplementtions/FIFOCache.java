package design_patterns.CacheImplementtions;

import design_patterns.Interfaces.ICache;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FIFOCache implements ICache {

    int capacity;
    String server;
    Map<String, Integer> dictMap;
    LinkedList<String> queue;

    public FIFOCache(int capacity) {
        this.capacity = capacity;
        this.server = "Global IT Cloud";
        this.dictMap = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    @Override
    public void put(String key, int value) {
        if (containsKey(key)) {
            dictMap.put(key, value);
            //update order of the key from queue
            queue.remove(key);
            queue.addLast(key);
        } else {
            while (getSize() >= capacity) {
                //remove the oldest element from queue and cache
                String oldestElement = queue.removeFirst();
                dictMap.remove(oldestElement);
            }
            dictMap.put(key, value);
            queue.addLast(key);
        }
    }

    @Override
    public Integer get(String key) {
        if (containsKey(key)) {
            return dictMap.get(key);
        }
        System.out.println(MessageFormat.format("ERROR: Key {0} is not in cache", key));
        return null;
    }

    @Override
    public void remove(String key) {
        if (containsKey(key)) {
            dictMap.remove(key);
            queue.remove(key);
        } else {
            System.out.println(MessageFormat.format("ERROR: Key {0} is not in cache", key));
        }
    }

    @Override
    public void put() {

    }

    @Override
    public void clear() {
        dictMap.clear();
        queue.clear();
    }

    @Override
    public int getSize() {
        return dictMap.size();
    }

    @Override
    public boolean containsKey(String key) {
        return dictMap.containsKey(key);
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
