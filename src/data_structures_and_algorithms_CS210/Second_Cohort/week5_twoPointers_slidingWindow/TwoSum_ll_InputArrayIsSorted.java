package data_structures_and_algorithms_CS210.Second_Cohort.week5_twoPointers_slidingWindow;

import java.util.Arrays;

public class TwoSum_ll_InputArrayIsSorted {
    /**
     * The idea is to maintain 2 pointers!
     * <p>
     * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
     * <p>
     * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
     * <p>
     * The tests are generated such that there is exactly one solution. You may not use the same element twice.
     * <p>
     * Your solution must use only constant extra space.
     * <p>
     * Example 1:
     * <p>
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
     * Example 2:
     * <p>
     * Input: numbers = [2,3,4], target = 6
     * Output: [1,3]
     * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
     */
    // numbers = [2, 7, 11, 15] , target = 9
    //if you want to increase the sum you should move the left pointer +1 further(so not 2 but 7), if you want to decrease the sum you should move the right pointer to the left -1(so not 15 but 11)
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        //return indexes that should be returned 1 indexed, bc the arr is 0 indexed
        return new int[]{left + 1, right + 1};
    }
}
