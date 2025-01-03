package java_intro.week10.HW_10;

import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    /*
    Create a thread-safe cache system using ConcurrentHashMap.
● The Cache class should have:
○ A method put(String key, String value) to add entries.
○ A method get(String key) to retrieve entries.
● Simulate multiple threads accessing the cache for reading and writing.
Requirements:
● Use at least 3 writer threads and 3 reader threads.
● Print messages when data is added or retrieved.
     */

    //class is a thread-safe version of HashMap. It allows safe concurrent access by multiple threads without needing explicit synchronization.
private final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

//to add data to the map
    public void put(String key, String value){
        cache.put(key,value);
        System.out.println("Data added to cache: key-"+ key + "\nvalue-"+value);
    }

    //to retrieve data from cache
    public String retrieve(String key){
        String value = cache.get(key);
        System.out.println("Data retrieved to cache: key-"+ key + "\nvalue-"+value);
        return value;
    }

    public static void main(String[] args) {
        Cache cache1 = new Cache();
        // Writer threads
        Runnable writerTask1 = () -> {
            for (int i = 0; i < 5; i++) {
                cache1.put("Key" + i, "Value" + i);
                try {
                    Thread.sleep(100); // Simulate delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Writer threads
        Runnable writerTask2 = () -> {
            for (int i = 0; i < 5; i++) {
                cache1.put("Key" + i, "Value" + i);
                try {
                    Thread.sleep(100); // Simulate delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Writer threads
        Runnable writerTask3 = () -> {
            for (int i = 0; i < 5; i++) {
                cache1.put("Key" + i, "Value" + i);
                try {
                    Thread.sleep(100); // Simulate delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Reader threads
        Runnable readTask1 = () -> {
            for (int i = 0; i < 5; i++) {
                cache1.retrieve("Key" + i);
                try {
                    Thread.sleep(100); // Simulate delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Reader threads
        Runnable readTask2 = () -> {
            for (int i = 0; i < 5; i++) {
                cache1.retrieve("Key" + i);
                try {
                    Thread.sleep(100); // Simulate delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Reader threads
        Runnable readTask3 = () -> {
            for (int i = 0; i < 5; i++) {
                cache1.retrieve("Key" + i);
                try {
                    Thread.sleep(100); // Simulate delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Create and start threads
        Thread writer1 = new Thread(writerTask1);
        Thread writer2 = new Thread(writerTask2);
        Thread writer3 = new Thread(writerTask3);

        Thread reader1 = new Thread(readTask1);
        Thread reader2 = new Thread(readTask2);
        Thread reader3 = new Thread(readTask3);

        writer1.start();
        writer2.start();
        writer3.start();

        reader1.start();
        reader2.start();
        reader3.start();

        // Wait for threads to complete
        try {
            writer1.join();
            writer2.join();
            writer3.join();
            reader1.join();
            reader2.join();
            reader3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have finished execution.");
    }

}
