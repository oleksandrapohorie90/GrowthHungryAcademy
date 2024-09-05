package cs_and_programming.CS_DESIGN_PATTERNS;

public class BuilderDesignPattern {
    /*
    your cache needs to have multiple configuration options, like capacity, expiration time, or eviction strategy (LRU, FIFO). The builder pattern allows you to construct the cache with different configurations in a more readable and flexible way.
     */
    private int capacity = 100;
    private EvictionStrategy strategy = EvictionStrategy.LRU;

    public BuilderDesignPattern setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public BuilderDesignPattern setEvictionStrategy(EvictionStrategy strategy) {
        this.strategy = strategy;
        return this;
    }

    public SingletonDesignPattern build() {
        SingletonDesignPattern cache = SingletonDesignPattern.getInstance(capacity, strategy);
        // we can also set the eviction strategy in the SingletonDesignPattern instance here if needed
        return cache;
    }

    public enum EvictionStrategy {
        LRU,   // Least Recently Used
        FIFO,  // First In First Out
        LFU    // Least Frequently Used
    }
}
