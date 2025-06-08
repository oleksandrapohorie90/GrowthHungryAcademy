package data_structures_and_algorithms_CS210.Second_Cohort.week28_Greedy_Algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        // [[1,2],[2,3],[3,4],[1,3], [3,4], [1,2]]
        // [[1,2], [2,3],[3,4]]
        // minheap
        // top - 2

        // start 1 >=?  minheap 2  good
        // minheap.pop
        // add current end 2 add to minheap
        // start 1 >=?  minheap 2  not good
        // count of return++
        // minheap.pop
        // add current end 3 add to minheap
        // start 2 >=?  minheap 3   not good
        // count of return++
        // minheap.pop
        // add current end 3 add to minheap
        // start 3 >=?  minheap 3 good
        // minheap.pop
        // add current end 4 add to minheap
        // start 3 >=?  minheap 4 not good
        // count of return++

        // ignore
        // [[1,2],[1,3], [2,3],[3,4],]

        //count++

        // [[1,2],[2, 3]]

        // [,[1,11],[1,100], [2,12],[11,22]]
        // minheap 11 current 1
        // count++
        // minheap 11 current 2
        // count++
        // minheap 11 current 11
        //

        // [[-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]]


        // [-73, -26][-65, -11] [-63, 2][-62, -49][-52, 31][-40, -26][-31, 49][30, 47][58, 95][66, 98][82, 97][95, 99]

        // -26 ? -65 not good
        // count++

        // -26 ? -63 not good count++

        // -26 ? -62 not good count ++

        // -26 ? -52 not good count++
        // -26 ? -40 not good count++
        // -26 ? -31 not good count++
        // -26 ? 30 add minheap 47
        // 47 ? 58 add minheap 95
        // 95 ? 66 not good count++
        // 95 ? 82 not good count++
        // 95 ? 95


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

    //chat gpt
//    public int eraseOverlapIntervals(int[][] intervals) {
//        int res = 0;
//
//        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
//        int prev_end = intervals[0][1];
//
//        for(int i = 1; i < intervals.length ; i++){
//            if(prev_end > intervals[i][0]){
//                res++;
//            }else{
//                prev_end = intervals[i][1];
//            }
//        }
//
//
//
//
//        return res;
//    }

}
