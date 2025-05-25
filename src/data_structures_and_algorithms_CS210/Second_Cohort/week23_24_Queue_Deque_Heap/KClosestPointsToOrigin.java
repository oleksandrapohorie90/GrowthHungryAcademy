package data_structures_and_algorithms_CS210.Second_Cohort.week23_24_Queue_Deque_Heap;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kCloset(int[][] points, int k) {
        //dist[i] = points[i][0]^2 + point[i][1]^2
        //int[] -> [dist[i], i]
        //1. compute the distance 2. create max heap 3. go through points one by one and we put inside the pairs distance and the index of this point
        int n = points.length;
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = points[i][0] * points[i][1] + points[i][1] * points[i][1];
        }
        PriorityQueue<int[]> max_heap = new PriorityQueue<>((pair1, pair2) -> pair2[0] - pair1[0]);

        for (int i = 0; i < n; i++) {
            int[] current_pair = new int[2];
            current_pair[0] = dist[i];
            current_pair[1] = i;
            max_heap.offer(current_pair);
            if (max_heap.size() > k) {
                max_heap.poll();
            }
        }
        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] current_pair = max_heap.poll();
            int index = current_pair[1];
            answer[i][0] = points[index][0];
            answer[i][1] = points[index][1];
        }
        return answer;
    }

}
