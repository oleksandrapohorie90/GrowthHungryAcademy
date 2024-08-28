package data_structures_and_algorithms.week16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    //will have to use HashMap
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6};
        int target = 4;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        //          i=5
        // [..., nums[i] = 17, ...]
        // target = 77
        // lastSeenSoFar = { 22: 0, 61: 1, 23: 4, 56: 3, 12: 2 }
        // lastSeenSoFar.containsKey(77 - 17, i.e. 60) -> false
        // No problem, let's record -> lastSeenSoFar.put(17, 5) // key=17 (number), value=5 (lastSeenIndex)
        // lastSeenSoFar = { 22: 0, 61: 1, 23: 4, 56: 3, 12: 2, 17: 5}

        //          i=6
        // [..., nums[i] = 21, ...]
        // target = 77
        // lastSeenSoFar = { 22: 0, 61: 1, 23: 4, **56: 3**, 12: 2, 17: 5}
        // lastSeenSoFar.containsKey(77 - 21, i.e. 56) -> true
        // Cool! Return {lastSeenSoFar.get(56) [i.e. 3], i [i.e. 6]}

        // Map<Number, IndexLastSeen>
        Map<Integer, Integer> lastSeenSoFar = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target - a;
            if (lastSeenSoFar.containsKey(b)) {
                return new int[]{lastSeenSoFar.get(b), i};
            }
            lastSeenSoFar.put(a, i);
        }
        return new int[]{};
    }

}
