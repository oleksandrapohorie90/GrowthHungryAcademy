package java_intro.week10;

public class SemaphoreExample {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(5); // 5 seats available
        for (int i = 1; i <= 10; i++) {
            String customer = "Customer-" + i;
            new Thread(() ->
                    restaurant.enterRestaurant(customer)).start();
        }
    }
}
