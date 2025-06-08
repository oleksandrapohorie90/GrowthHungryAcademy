package data_structures_and_algorithms_CS210.Second_Cohort.week28_Greedy_Algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        //sort the array first
        // [[1,2],[2,3],[3,4],[1,3]]
        //Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        int count = 0;
        // [[1,2],[1,3],[2,3],[3,4]]
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int startTime = intervals[i][0];
            int prevEndTime = minHeap.peek();
            int currentEndTime = intervals[i][1];
            if (startTime < prevEndTime) {
                count++;
                if (prevEndTime > currentEndTime) {
                    //prevEndTime = currentEndTime; //reassign smaller endTime
                    // Current one ends earlier — better to keep
                    minHeap.poll(); // remove the worse one
                    minHeap.add(currentEndTime); // keep current
                }
            } else {
                //good, reuse the end time from heap
                minHeap.poll();
                minHeap.add(intervals[i][1]);
            }
        }
        return count;
    }
}
