package cs_and_programming.CS_DESIGN_PATTERNS;

public class Main {
    public static void main(String[] args) throws Exception {
        Cache cache = new Cache(5); //cache capacity of 5

        cache.put("Alex", 20);
        cache.put("Hanna", 25);
        cache.put("Olga", 29);
        cache.put("Ihor", 26);
        cache.put("Viktor", 35);

        System.out.println(cache.get("Olga"));
        cache.put("Elena", 40); //removes Alex
        System.out.println(cache.containsKey("Alex")); //false, since capacity was reached and Alex got removed

        System.out.println(cache.size()); //always will be 5
        SingletonDesignPattern cache1 = SingletonDesignPattern.getInstance(100); // Creates the instance
        SingletonDesignPattern cache2 = SingletonDesignPattern.getInstance(200); // Returns the existing instance
        System.out.println(cache1 == cache2); // true - both references point to the same instance

    }
}
