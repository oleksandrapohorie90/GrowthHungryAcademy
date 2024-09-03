package data_structures_and_algorithms_CS210.DS_QUEUE;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfrecentCalls {
    private Queue<Integer> requests;

    public NumberOfrecentCalls() {
        this.requests = new LinkedList<>();
    }

    public int ping(int t) { //Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds
        requests.add(t);
        while(requests.peek() < t - 3000){ //.peek() - retrieves but not removes, the highest priority element
            requests.poll(); //returns the high priority element and removes
        }
        return requests.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */

