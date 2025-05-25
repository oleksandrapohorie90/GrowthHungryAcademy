package data_structures_and_algorithms_CS210.Second_Cohort.week23_24_Queue_Deque_Heap;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        //if you have a min_heap you insert elements one by one
        //there might be the k-th largest element
        //how do you insure at the end you get largest element
        //you will know the largest or smallest but it wont be sorted
        //put all of elements in max_heap and then remove k-1 times untill we get the k-th

        //is there a better option
        //if we have a min heap and we add elemnts to it, when size becomes k+1, we remove furthest(min element), we only keep k-th largest, when i do priority.peek() i remove min in the min_heap again
        //[1 2 3 4 5 6 7 8 9] - I need to find 4-th largest k = 4 = 6 value from arr
        //we always end up with k-th largest elements bc we will remove smallest
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : nums) {
            pq.offer(x);
            if (pq.size() == k + 1) {
                pq.poll(); //will remove smallest
            }
        }
        return pq.peek(); //on top k-th largest

    }
}
