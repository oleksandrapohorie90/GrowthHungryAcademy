package design_patterns.Interfaces;

public interface ICache {
    // implemented a factory pattern: create different types of caches
   void put(String key, int value);
   Integer get(String key);
   void remove(String key);
   void  put();
   void clear();
   int getSize();
   boolean containsKey(String key);
}
