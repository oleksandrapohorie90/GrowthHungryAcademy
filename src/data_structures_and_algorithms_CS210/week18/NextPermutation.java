package data_structures_and_algorithms_CS210.week18;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // 1 2 3
        // 1 3 2
        // 2 1 3
        // 2 3 1

        // 1 2 3 4
        // 1 2 4 3
        // 1 3 2 4
        // 1 3 4 2
        // 1 4 2 3

        // i-1 i   j
        // 2 1 3 4
        //
        //


        // i-1 i j
        // 3 1 2 4


        // 2 1 3 4
        // 2 1 4 3
        // 2 3 1 4
        // 2 3 4 1
        // 2 4 1 3
        // 2 4 3 1
        // 3 1 2 4
        // ...

        // i-1 i
        //     j
        // 3 4 2 1

        //

        //   i
        // 4 3 2 1

        int n = nums.length;

        // We are going to find the leftmost i such that
        // nums[i] >= nums[i + 1] >= ... >= nums[n - 1]
        int i = n - 1;
        while (i - 1 >= 0 && nums[i - 1] >= nums[i]) {
            i--;
        }

        // It means that the current permutation is
        // the last possible permutation, so the next permutation
        // is going to be the very first permutation (which is a ascendingly sorted array).
        if (i == 0) {
            // Simply, reverse the array.
            Arrays.sort(nums);
            return;
        }

        // j is going to be the index of the next greater number than nums[i - 1].
        int j = -1;
        for (int k = i; k < n; k++) {
            if (nums[k] > nums[i - 1] && (j == -1 || nums[k] <= nums[j])) {
                j = k;
            }
        }

        // swap(nums[i - 1], nums[j]);
        int t = nums[i - 1];
        nums[i - 1] = nums[j];
        nums[j] = t;

        // reverse(nums, i, n - 1);
        for (int left = i, right = n - 1; left < right; left++, right--) {
            // swap(nums[left], nums[right]);
            t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
        }
    }
}

