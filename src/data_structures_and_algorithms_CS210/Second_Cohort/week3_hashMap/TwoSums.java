package data_structures_and_algorithms_CS210.Second_Cohort.week3_hashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    //Is it better on the interview to solve it with HashMap or with Arrays ?
    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * <p>
     * You can return the answer in any order.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     * Example 2:
     * <p>
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * Example 3:
     * <p>
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     */
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

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
        for (int i = 0; i < nums.length; ++i) {
            int b = nums[i];
            int a = target - b;
            if (lastSeenSoFar.containsKey(a)) {
                // Found pair of (a, b), so that a + b = target
                // Number a last seen at index lastSeenSoFar.get(a)
                // and number b is last seen at index i.
                return new int[]{lastSeenSoFar.get(a), i};
            }
            // Save that number b (nums[i]) last seen at index i.
            lastSeenSoFar.put(b, i);
        }
        return new int[]{};
    }
}
