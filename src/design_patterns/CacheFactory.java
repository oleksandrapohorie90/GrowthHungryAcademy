package design_patterns;

import design_patterns.CacheImplementtions.CacheType;
import design_patterns.CacheImplementtions.FIFOCache;
import design_patterns.CacheImplementtions.LRUCache;
import design_patterns.Interfaces.ICache;

public class CacheFactory {
    public static ICache createCacheInstance(CacheType type) throws Exception {
        //will be singleton at first
        //should provide diff caches by some type
        //give the type and it will create some implementation, thats why we have switch
        switch (type) {
            case CacheType.FIFO:
                return new FIFOCache();
            case CacheType.LRU:
                return new LRUCache();
            default:
                throw new Exception("Type is not implemented");
        }
    }
}
