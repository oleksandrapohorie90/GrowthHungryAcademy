package java_intro.week10.HW_10;

import java_intro.week10.Restaurant;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private final Semaphore parking_spots;

    public SemaphoreExample(int seatCount) {
        this.parking_spots = new Semaphore(seatCount);
    }
    public void enterParkingLot(String car) {
        try {
            System.out.println(car + " is waiting for a spot...");
            parking_spots.acquire(); // Wait for an available spot to park
            System.out.println(car + " got a spot.");
            Thread.sleep(2000); // Simulate time spent parking
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            parking_spots.release(); // Release the spot
            System.out.println(car + " left the spot.");
        }
    }

    public static void main(String[] args) {
        SemaphoreExample parkingLot = new SemaphoreExample(5); // 5 available parking spots
        for (int i = 1; i <= 10; i++) {
            String car = "Car-" + i;
            new Thread(() ->
                    parkingLot.enterParkingLot(car)).start();
        }
    }
}
