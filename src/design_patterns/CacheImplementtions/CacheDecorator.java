package design_patterns.CacheImplementtions;

import design_patterns.Interfaces.ICache;

public class CacheDecorator implements ICache {
    ICache cache;

    public CacheDecorator(ICache cache) {
        this.cache = cache;
    }

    @Override
    public void put(String key, int value) {

    }

    @Override
    public Integer get(String key) {
        return cache.get(key);
    }

    @Override
    public void remove(String key) {
        cache.remove(key);
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
