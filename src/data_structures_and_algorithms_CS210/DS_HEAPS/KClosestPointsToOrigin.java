package data_structures_and_algorithms_CS210.DS_HEAPS;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int [][] points, int k){

        //O(logn)
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
                (p1,p2) -> (p1[0] *p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] +p2[1] *p2[1])
        );
        int n = points.length;
        for (int i = 0; i < n; i++) {
            pq.add(points[i]);
        }
        int[][] results = new int[k][2];
        for (int i = 0; i < k; i++) {
        results[i] = pq.poll();
        }

        //calc all the distance to all the points and sort
        //Comparator in java => some value negative/ 0 or positive => .compareTo()
        //1st obj = 2nd obj => 0
        //very left of the array is the min in sorted arr 1st obj < (should appear to the left of 2nd obj ) 2nd => negative -1
        //1st ob should appear to the right side of the 2nd object => positive 1

        //Arrays.sort(points, (p1,p2) -> (p1[0] *p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] +p2[1] *p2[1]));
        return Arrays.copyOfRange(points,0,k);
    }
}
