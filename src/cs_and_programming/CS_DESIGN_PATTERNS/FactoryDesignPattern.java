package cs_and_programming.CS_DESIGN_PATTERNS;

interface FactoryDesignPattern {
    /*
    can be used to create different types of caches to implement different eviction strategies (e.g., LRU, LFU, or FIFO). Using a factory, to create specific caches depending on the needs of the application.
     */
    SingletonDesignPattern createCache(int capacity);
}

class LRUCacheFactory implements FactoryDesignPattern {
    @Override
    public SingletonDesignPattern createCache(int capacity) {
        // Can also customize LRU-specific details
        return SingletonDesignPattern.getInstance(capacity);
    }
}

class FIFOCacheFactory implements FactoryDesignPattern {
    @Override
    public SingletonDesignPattern createCache(int capacity) {
        // Implement FIFO specific details if needed
        return SingletonDesignPattern.getInstance(capacity);
    }
}
