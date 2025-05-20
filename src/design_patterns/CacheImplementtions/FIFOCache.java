package design_patterns.CacheImplementtions;

import design_patterns.Interfaces.ICache;

public class FIFOCache implements ICache {

    int capacity;
    public FIFOCache(int capacity){
        this.capacity = capacity;
    }

    @Override
    public void put(String key, int value) {

    }

    @Override
    public int get(String key) {
        return 0;
    }

    @Override
    public void remove(String key) {

    }

    @Override
    public void put() {

    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
}
