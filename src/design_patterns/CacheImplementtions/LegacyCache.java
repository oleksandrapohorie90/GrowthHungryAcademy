package design_patterns.CacheImplementtions;

import design_patterns.Interfaces.ICache;

import java.util.HashMap;
import java.util.Map;

public class LegacyCache implements ICache {
    //this code is some client code that you cannot change
    Map<String, Integer> cache = new HashMap<>();

    @Override
    public void put(String key, int value) {
        cache.put(key, value);
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
        return cache.size();
    }

    @Override
    public boolean containsKey(String key) {
        return false;
    }
}
