package design_patterns.CacheImplementtions;

import design_patterns.Interfaces.ICache;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LFUCache implements ICache {

//    int capacity;
//    String serverName;
//    Map<String, LFUCacheItem> keyToCacheItemMap;
//    PriorityQueue<LFUCacheItem> keyFrequencesMinHeap;
//
//    public LFUCache{
//        this.capacity = 10;
//        this.keyFrequencesMinHeap = new HashMap<>();
//        this.keyFrequencesMinHeap = new PriorityQueue<>(Comparator.comparingInt(value -> value.getFrequency()));
//    }
    @Override
    public void put(String key, int value) {

    }

    @Override
    public Integer get(String key) {
        return 0;
    }

    @Override
    public void remove(String key) {

    }

    @Override
    public void put() {

    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean containsKey(String key) {
        return false;
    }
}
