package data_structures_and_algorithms_CS210.Second_Cohort.week23_24_Queue_Deque_Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    //poll() retrieve and remove it
    //if 2 are not equal we have to sub
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            int largest = maxHeap.poll();
            int second_largest = maxHeap.poll();

            if (largest != second_largest) {
                maxHeap.offer(largest - second_largest);
            }
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.peek();
    }

}
