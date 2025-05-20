package design_patterns.CacheImplementtions;

import design_patterns.Interfaces.ICache;

public class LegacyCacheAdapter implements ICache {
    LegacyCache legacyCache;
    int capacity;

    public LegacyCacheAdapter(LegacyCache legacyCache, int capacity) {
        this.legacyCache = new LegacyCache();
        this.capacity = capacity;
    }

    @Override
    public void put(String key, int value) {
        if (legacyCache.getSize() >= capacity) {
            System.out.println("Cache is full");
            return;
        }

        legacyCache.put(key, value);
    }

    @Override
    public Integer get(String key) {
        return legacyCache.get(key);
    }

    @Override
    public void remove(String key) {
        legacyCache.remove(key);
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
    //now I need to check capacity for my cache in my system
}
