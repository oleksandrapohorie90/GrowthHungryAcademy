package design_patterns;

import design_patterns.CacheImplementtions.CacheType;
import design_patterns.Interfaces.ICache;

public class App {

    public static void main(String[] args) throws Exception {
        ICache cache = CacheFactory.createCacheInstance(CacheType.FIFO);
        cache.put("Alex", 30);
        System.out.println("Age of Alex " + cache.get("Alex"));

    }
}
