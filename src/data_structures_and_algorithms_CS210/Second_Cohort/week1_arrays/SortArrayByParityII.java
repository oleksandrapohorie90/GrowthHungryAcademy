package data_structures_and_algorithms_CS210.Second_Cohort.week1_arrays;

import java.util.Arrays;

public class SortArrayByParityII {

    /**
     * Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
     * <p>
     * Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
     * <p>
     * Return any answer array that satisfies this condition.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [4,2,5,7]
     * Output: [4,5,2,7]
     * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
     * Example 2:
     * <p>
     * Input: nums = [2,3]
     * Output: [2,3]
     */
    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 7};
        System.out.println(Arrays.toString(sortArrayByParityII(nums)));
    }

    public static int[] sortArrayByParityII(int[] nums) {

        int i = 0;
        int j = 1;
        int n = nums.length;

        while (i < n && j < n) {
            while (i < n && nums[i] % 2 == 0) {
                i += 2;
            }
            while (j < n && nums[j] % 2 == 1) {
                j += 2;
            }

            if (i < n && j < n) {
                swap(nums, i, j);
            }
        }



        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
