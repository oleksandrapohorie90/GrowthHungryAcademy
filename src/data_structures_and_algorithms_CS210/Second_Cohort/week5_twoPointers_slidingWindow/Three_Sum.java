package data_structures_and_algorithms_CS210.Second_Cohort.week5_twoPointers_slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
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
         * 1.handle the base case
         * 2. sort the array to implement the TwoSum II - Input Array Is Sorted idea
         * 3. fix the element 'i', but with additional logic to skip the duplicates for the 1st number, for example if i=-5 and incremented to index 1 and the value is -5 then it will skip it since it already saw -5 in the index 0
         * 4. then it does 2 sum idea with sorted array on the rest of the array
         * 5. then it does smth smart to skip the duplicates for 2nd and 3rd number as well with while loops
         * time complexity: n^2 - each num btw left and right will be visited only once
         *space complexity: O(n) because of the sorting
         * which sorting algo does array.sort use ->
         * Arrays.sort(n) -> log n time complexity
         *
         *
         */
        List<List<Integer>> ans = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    // Found a triplet with zero sum
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Skip duplicate elements for j
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    // Skip duplicate elements for k
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    // Move the pointers
                    j++;
                    k--;
                } else if (sum < 0) {
                    // Sum is less than zero, increment j to increase the sum
                    j++;
                } else {
                    // Sum is greater than zero, decrement k to decrease the sum
                    k--;
                }
            }
        }
        return ans;
    }
}


