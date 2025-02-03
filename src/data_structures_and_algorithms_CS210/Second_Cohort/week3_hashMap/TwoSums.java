package data_structures_and_algorithms_CS210.Second_Cohort.week3_hashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.

     * Example 1:
     *
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     * Example 2:
     *
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * Example 3:
     *
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     */
    public static void main(String[] args) {
        int [] nums = {3,2,4};
        int target = 6;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lastSeenSoFar = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int b = nums[i];
            int a = target - b;
            if(lastSeenSoFar.containsKey(a)){
               return new int[] {lastSeenSoFar.get(a),i};
            }
            lastSeenSoFar.put(b,i);
        }
        return new int []{};
    }
}
