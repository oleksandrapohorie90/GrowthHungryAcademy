package design_patterns;

import design_patterns.CacheImplementtions.CacheType;
import design_patterns.CacheImplementtions.FIFOCacheBuilder;
import design_patterns.CacheImplementtions.LFUCache;
import design_patterns.Interfaces.ICache;

public class CacheFactory {
    public static ICache createCacheInstance(CacheType type) throws Exception {
        //will be singleton at first
        //should provide diff caches by some type
        //give the type and it will create some implementation, thats why we have switch
        switch (type) {
            case CacheType.FIFO:
                //return new FIFOCache(3);
                FIFOCacheBuilder gBuilder = new FIFOCacheBuilder();
                gBuilder = gBuilder.setCapacity(30).setServerName("Google Cloud");
                return gBuilder.build();
            case CacheType.FIFOAmazon:
                //return new FIFOCache(3);
                FIFOCacheBuilder amazonCacheBuilder = new FIFOCacheBuilder();
                amazonCacheBuilder = amazonCacheBuilder.setServerName("Amazon WS");
                return amazonCacheBuilder.build();
            case CacheType.LRU:
                return new LFUCache();
            default:
                throw new Exception("Type is not implemented");
        }
    }
}
