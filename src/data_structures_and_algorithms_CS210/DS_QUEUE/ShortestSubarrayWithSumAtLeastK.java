package data_structures_and_algorithms_CS210.DS_QUEUE;
import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtLeastK {
        public int shortestSubarray(int[] A, int K) {
            int N = A.length, res = N + 1;
            long[] B = new long[N + 1];
            for (int i = 0; i < N; i++) B[i + 1] = B[i] + A[i];
            Deque<Integer> d = new ArrayDeque<>();
            for (int i = 0; i < N + 1; i++) {
                while (d.size() > 0 && B[i] - B[d.getFirst()] >=  K)
                    res = Math.min(res, i - d.pollFirst());
                while (d.size() > 0 && B[i] <= B[d.getLast()])
                    d.pollLast();
                d.addLast(i);
            }
            return res <= N ? res : -1;
        }
    }

