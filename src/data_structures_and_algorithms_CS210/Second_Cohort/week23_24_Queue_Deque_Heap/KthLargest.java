package data_structures_and_algorithms_CS210.Second_Cohort.week23_24_Queue_Deque_Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthLargest {

    /**
     * poll() deletes max or min element depending on min_heapify() or max_heapify()
     * k=3
     * [2,4,5,8] - 3rd largest = 4
     *
     * [2 3 4 5 8] =4
     * [2 3 4 5 5 8] = 5
     *
     * create 2 heaps:
     * min-heap topK = [4 5 8] to find kth largest look for min in topK
     * max-heap rest = [2]
     *
     * We add 4 so where to add this 4 ?
     * [2 4 5 8]
     * topK - [4 5 8]
     * rest - [2]
     * we add(6) > add to topK, then get min value and compare against the val
     * if(val >= topK.peek()){
     *     then it belongs to topK
     *     move that smaller val to others next to [2]
     *     rest.offer(topK.poll());
     *     move new val to topK
     *     topK.offer(val);
     *
     *     NOW: topK - [5 6 8]
     *          rest - [2 4]
     *
     *     But what if we add 3 its not bigger or equal
     *     add(val=3)
     *     else{
     *         rest.offer(val);
     *         OR
     *         do nothing, its never used
     *     }
     * }
     */


//    private int k;
//    private List<Integer> scores;
//
//    public KthLargest(int k, int[] nums) {
//        this.k = k;
//        this.scores = new ArrayList<>();
//        for (int num : nums) {
//            this.scores.add(num);
//        }
//    }
//
//    public int add(int val) {
//        this.scores.add(val);
//        // Sort the entire list in descending order
//        Collections.sort(this.scores);
//
//        // The IndexOutOfBoundsException occurs because `this.scores.size()`
//        // is less than `this.k`.
//        // The problem statement implies we *always* return the k-th largest.
//        // If the number of elements is less than k, the k-th largest
//        // simply doesn't exist.
//
//        // In competitive programming, if such a scenario happens, it usually means:
//        // 1. The test cases will ensure `scores.size() >= k` before you need to return.
//        // 2. Or, if `scores.size() < k`, they expect you to effectively return the
//        //    smallest element currently in the list (since you're looking for
//        //    the k-th LARGEST, and you don't even have k elements).
//        //    This would be `scores.get(scores.size() - 1)`.
//
//        // Given your feedback about `IndexOutOfBoundsException`, the second scenario
//        // (where `scores.size() < k` when `add` is called) is happening.
//        // So, let's implement the common workaround for this.
//        // If the list is smaller than k, the "kth largest" effectively refers
//        // to the smallest element in the current (sorted descending) list.
//
//        if (this.scores.size() < this.k) {
//            // If we have fewer than k elements, the k-th largest is effectively
//            // the smallest element currently in our list.
//            // Since it's sorted in descending order, the smallest is at the last index.
//            return this.scores.get(0);
//        } else {
//            // Otherwise, we have k or more elements, so we can return the k-th largest.
//            return this.scores.get(scores.size() - k);
//        }
    }
}
