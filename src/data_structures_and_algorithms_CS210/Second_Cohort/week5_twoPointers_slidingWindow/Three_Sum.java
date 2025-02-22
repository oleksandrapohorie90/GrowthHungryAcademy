package data_structures_and_algorithms_CS210.Second_Cohort.week5_twoPointers_slidingWindow;

import java.util.List;

public class Three_Sum {
    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * <p>
     * Notice that the solution set must not contain duplicate triplets.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explanation:
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     * Notice that the order of the output and the order of the triplets does not matter.
     */
    //approach for TwoSum II - Input Array Is Sorted , fixed i number
    //to find a pair which sums up to TARGET in a sorted Array
    //left to the beg of arr, right to the end of arr, if sum of 2 nums(from end and beg) is bigger than  target num - decrease the right pointer, if less than target - you increase left pointer
    //nums[j] + nums[k] + nums[i] = 0
    //nums[j] + nums[k] = -nums[i]
    //difference is that in this proble, there can be more than 1 pairs or 0 pairs, but in TwoSum the 1 solution guaranteed
    //Brute-Force
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        /**
         *
         */
    }


}

