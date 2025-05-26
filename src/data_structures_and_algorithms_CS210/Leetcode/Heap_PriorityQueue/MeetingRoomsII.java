package data_structures_and_algorithms_CS210.Leetcode.Heap_PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.offer(intervals[0][1]); // 0, 30

        for (int i = 1; i < intervals.length; i++) {
            int currentStartTime = intervals[i][0];
            int lastEndTime = minHeap.peek();
            if (currentStartTime < lastEndTime) {
                minHeap.offer(intervals[i][1]);
            } else {
                minHeap.poll();
                minHeap.offer(intervals[i][1]);
            }
        }
        return minHeap.size();
    }

    public int minMeetingRooms2(int[][] intervals) {

        int minRooms = 1;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int index = 0; index < intervals.length; index++) {
            start[index] = intervals[index][0];
            end[index] = intervals[index][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int startIndex = 1;
        int endIndex = 0;
        while (startIndex < intervals.length) {
            if (start[startIndex++] < end[endIndex]) {
                minRooms++;
            } else {
                endIndex++;
            }
        }
        return minRooms;
    }
}

