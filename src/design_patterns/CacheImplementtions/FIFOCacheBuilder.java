package design_patterns.CacheImplementtions;

public class FIFOCacheBuilder {
    private FIFOCache fifoCache;

    //builder design patter
    public FIFOCacheBuilder() {
        fifoCache = new FIFOCache(3);
    }

    public FIFOCacheBuilder setCapacity(int capacity) {
        fifoCache.setCapacity(capacity);
        return this;
    }

    public FIFOCacheBuilder setServerName(String server) {
        fifoCache.setServer(server);
        return this;
    }

    public FIFOCache build() {
        return fifoCache;
    }
}
