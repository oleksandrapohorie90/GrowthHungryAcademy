package cs_assembly.week10;

public class MemoryAllocator {

        public static void main(String[] args) {
            for (int i = 0; i < 1000; i++) {
                allocateMemory();
                System.out.println("Iteration: " + i);
                try {
                    Thread.sleep(50); // Add some delay to observe GC behavior
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private static void allocateMemory() {
            int arraySize = 1000000;
            int[][] largeArray = new int[arraySize][];
            for (int i = 0; i < arraySize; i++) {
                largeArray[i] = new int[10]; // Allocate small arrays
            }
        }
    }
    //serial gc
    //java -XX:+UseSerialGC -Xmx2G -Xms2G -XX:+PrintGCDetails -XX:+PrintGCDateStamps MemoryAllocator

//parallel gc
//java -XX:+UseSerialGC -Xmx2G -Xms2G -XX:+PrintGCDetails -XX:+PrintGCDateStamps MemoryAllocator

//G1GC
//java -XX:+UseG1GC -Xmx2G -Xms2G -XX:+PrintGCDetails -XX:+PrintGCDateStamps MemoryAllocator

//ZGC
//java -XX:+UseZGC -Xmx2G -Xms2G -XX:+PrintGCDetails -XX:+PrintGCDateStamps MemoryAllocator

