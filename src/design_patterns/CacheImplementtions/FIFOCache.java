package design_patterns.CacheImplementtions;

import design_patterns.Interfaces.ICache;

public class FIFOCache implements ICache {

    int capacity;
    String server;

    public FIFOCache(int capacity) {
        this.capacity = capacity;
        this.server = "Global IT Cloud";
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

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
