package design_patterns.Interfaces;

public interface ICache {
    // implemented a factory pattern: create different types of caches
   void put(String key, int value);
   int get(String key);
   void remove(String key);
   void  put();
}
