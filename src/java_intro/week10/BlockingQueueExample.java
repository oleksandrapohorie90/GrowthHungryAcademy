package java_intro.week10;

public class BlockingQueueExample {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                processor.placeOrder("Order-" + i);
                try {
                    Thread.sleep(500); // Simulate order placement delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        Thread consumer = new Thread(processor::processOrder);
        producer.start();
        consumer.start();
    }
}
