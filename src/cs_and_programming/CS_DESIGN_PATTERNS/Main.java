package cs_and_programming.CS_DESIGN_PATTERNS;

public class Main {
    public static void main(String[] args) throws Exception {
        Cache cache = new Cache(5); //cache capacity of 5

        cache.put("Alex",20);
        cache.put("Hanna",25);
        cache.put("Olga",29);
        cache.put("Ihor",26);
        cache.put("Viktor",35);

        System.out.println(cache.get("Olga"));
        cache.put("Elena",40); //removes Alex
        System.out.println(cache.containsKey("Alex"));
    }
}
