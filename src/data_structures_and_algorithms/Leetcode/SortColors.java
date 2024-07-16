package data_structures_and_algorithms.Leetcode;

public class SortColors {

    public void sortColors(int[] nums) {
/*
Three variables count0, count1, and count2 are initialized to 0.
These variables will be used to count the occurrences of 0, 1, and 2 respectively.
*/
        int count0 = 0, count1 = 0, count2 = 0;
/*
The first loop iterates through the array nums, counting the occurrences of 0, 1, and 2
by incrementing the corresponding count variables
 (count0, count1, and count2) when encountering each value.
*/
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {count0++;}
            if (nums[i] == 1) {count1++;}
            if (nums[i] == 2) {count2++;}
        }
/* After counting the occurrences, the second loop iterates through the array again.
For each index i, it checks whether i is less than count0, count0 + count1, or beyond that. Based on this condition, it assigns the values 0, 1, or 2 to the array nums accordingly.
If i is less than count0, it means we are still in the section where 0s should be placed, so nums[i] is set to 0.
If i is between count0 and count0 + count1, it means we are in the section where 1s should be placed, so nums[i] is set to 1.
If i is greater than or equal to count0 + count1, it means we are in the section where 2s should be placed, so nums[i] is set to 2.
After these steps, the array nums is rearranged such that all 0s are placed at the beginning, followed by all 1s, and then all 2s, maintaining their relative order within each group. This is achieved in linear time complexity, O(n), where n is the length of the array nums.*/
        for(int i = 0; i < nums.length; i++) {
            if (i < count0) {nums[i] = 0;}
            else if (i < count0 + count1) {nums[i] = 1;}
            else {nums[i] = 2;}
        }
    }
}
