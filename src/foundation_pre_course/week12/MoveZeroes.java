package foundation_pre_course.week12;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,0, 1, 0, 3, 12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }
        //insert zeroes to the array
        int insert_zeroes_position = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insert_zeroes_position] = nums[i];
                insert_zeroes_position++;
            }
        }

        //fill out the rest of cells with zeros
        while (insert_zeroes_position < nums.length) {
            nums[insert_zeroes_position] = 0;
            insert_zeroes_position++;
        }

        System.out.println(Arrays.toString(nums));
    }
}
