package data_structures_and_algorithms_CS210.Second_Cohort.week5_twoPointers_slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
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
     */

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {

        //we need to find the sum of two numbers
        //we will have a map that will be empty and if we have the number that sum(target) - num 1 = num 2, then we want to return both numbers indexes
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int b = nums[i];
            int a = target - b;
            if (seen.containsKey(a)) {
                return new int[]{seen.get(a), i};
            }
            //save that number b (nums[i]) last seen at index i
            seen.put(b, i);
        }
        return new int[]{};
    }
}
