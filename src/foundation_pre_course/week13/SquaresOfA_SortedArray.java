package foundation_pre_course.week13;

import java.util.Arrays;

public class SquaresOfA_SortedArray {
    /*
    Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
     */
    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    //essence of 2 pointers technique
    public static int[] sortedSquares(int[] nums) {
        //the largest sqr is right end of the array squared or the left end
        //we can know it by taking the absolute values of the array
        int left = 0;
        int right = nums.length - 1;
        int [] res = new int[nums.length];

        //we will start from highest value to lowest - sorting
        for (int insertion_position = nums.length - 1; insertion_position >= 0; insertion_position--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[insertion_position] = nums[left] * nums[left];
                left++;
            } else {
                res[insertion_position] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
}
