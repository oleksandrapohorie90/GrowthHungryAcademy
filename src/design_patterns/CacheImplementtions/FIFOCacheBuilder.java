package design_patterns.CacheImplementtions;

public class FIFOCacheBuilder {
    private FIFOCache fifoCache;

    //builder design patter
    public FIFOCacheBuilder() {
        fifoCache = new FIFOCache();
    }

    public FIFOCacheBuilder setCapacity(int capacity) {
        fifoCache.setCapacity(capacity);
        return this;
    }

    public
}
