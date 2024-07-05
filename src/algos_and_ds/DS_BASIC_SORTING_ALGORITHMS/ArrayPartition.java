package algos_and_ds.DS_BASIC_SORTING_ALGORITHMS;

import java.util.Arrays;

public class ArrayPartition {

    //correct idea: sort array, take min consecutive elements
    //time complexity
    //
    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += Math.min(nums[i], nums[i + 1]);
        }
        return result;
    }
}
