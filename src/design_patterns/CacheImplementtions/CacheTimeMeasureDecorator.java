package design_patterns.CacheImplementtions;

import design_patterns.Interfaces.ICache;

public class CacheTimeMeasureDecorator extends CacheDecorator {
    public CacheTimeMeasureDecorator(ICache cache) {
        super(cache);
    }

    @Override
    public Integer get(String key) {
        long startTime = System.nanoTime();
        int cacheValue = super.get(key);
        long endTime = System.nanoTime();


        System.out.println((endTime - startTime) / 1000000);

        return cacheValue;

    }

}
