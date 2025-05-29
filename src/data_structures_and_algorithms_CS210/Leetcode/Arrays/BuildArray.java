package data_structures_and_algorithms_CS210.Leetcode.Arrays;

public class BuildArray {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            ans[index] = nums[nums[i]];
            index++;
        }

        return ans;
    }
}
