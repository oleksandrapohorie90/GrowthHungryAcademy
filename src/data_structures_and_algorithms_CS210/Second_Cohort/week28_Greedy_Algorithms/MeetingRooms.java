package data_structures_and_algorithms_CS210.Second_Cohort.week28_Greedy_Algorithms;

import java.util.Arrays;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        // if(intervals.length == 0) return true;
        // Arrays.sort(intervals, (a, b) -> a[0] - b[0]);


        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // // first end time
        // minHeap.add(intervals[0][1]);

        // for(int i = 1; i < intervals.length; i++){
        //     int currentStart = intervals[i][0]; // 5
        //     int prevEnd = minHeap.peek(); // 30
        //     int currentEnd = intervals[i][1];
        //     if(prevEnd > currentStart){
        //         return false;
        //     } else {
        //         minHeap.poll();
        //         minHeap.add(currentEnd);
        //     }
        // }
        // return true;

        // [[5,10],[15,20], [0,30]]
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0]; // 0
            int prevEnd = intervals[i - 1][1]; // 20
            // int currentEnd = intervals[i][1]; // 30
            if (prevEnd > currentStart) {
                return false;
            }
        }
        return true;
    }
}
