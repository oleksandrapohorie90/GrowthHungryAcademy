package data_structures_and_algorithms_CS210.Second_Cohort.week2_arrays2_ComeBack;

import java.util.Arrays;

public class SortColors {
    /**
     * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
     * <p>
     * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     * <p>
     * You must solve this problem without using the library's sort function.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * Example 2:
     * <p>
     * Input: nums = [2,0,1]
     * Output: [0,1,2]
     */
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        sortColors2(nums);
    }

    public static void sortColors(int[] nums) {

        int sorted_insertion = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1) {
                swap(nums, i, sorted_insertion);
                sorted_insertion++;
            }
        }
        for (int j = sorted_insertion; j < nums.length; j++) {
            if (nums[j] == 1) {
                swap(nums, j, sorted_insertion);
                sorted_insertion++;
            }
        }
        System.out.println("Input arr after sort: " + Arrays.toString(nums));
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public static void sortColors2(int[] nums) {
        int zero_insertPos = 0;
        int two_insertPosition = nums.length - 1;
        int i = 0;
        while (i <= two_insertPosition) {
            if(nums[i]==0){
                swap(nums,i,zero_insertPos);
                zero_insertPos++;
                i++;
            }else if(nums[i]==1){
                i++;
            }else{
                swap(nums,i,two_insertPosition);
                two_insertPosition--;
            }
        }
        System.out.println("Input arr after sort: " + Arrays.toString(nums));
    }

}
