package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical.tasks.day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class T05_ArrayMaxNum {

    public static int findMax(int[] nums) {
        if (nums.length == 0) return -1;

        int max = nums[0];
        for(int each : nums) {
            if (each > max) {
                max = each;
            }
        }
        return max;
    }

    @Test
    public void testMaxArr() {
        System.out.println(findMax(new int[]{3,2,4,5,5,0}));
        Assertions.assertEquals(5, findMax(new int[]{3,2,4,5,5,0}));
        Assertions.assertEquals(8, findMax(new int[]{8,2,4,5,5,0}));
    }

}
