package data_structures_and_algorithms_CS210.Leetcode.Queue_Deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class HitCounter {

    Deque<Integer> hits;

    public HitCounter() {
        hits = new ArrayDeque<>();
    }

    public void hit(int timestamp) {
        hits.add(timestamp); //1,3, 4,6,8, 300, 305
    }

    public int getHits(int timestamp) {
        // 301 - 299 = 2
        int count = 0;
        if (timestamp <= 300) {
            for (int hit : hits) {
                if (hit <= timestamp) count++;
            }
            return count;
        } else {
            int start = 0;
            start = timestamp - 299; //2
            for (int hit : hits) {
                if (hit >= start && hit <= timestamp) count++;
            }
            return count;
        }

    }
}
