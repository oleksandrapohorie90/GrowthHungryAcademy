package data_structures_and_algorithms_CS210.Second_Cohort.week25_BasicSorts;

public class SortArray {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int k = 100000; // range after shift

        // Step 1: Shift numbers to make them all positive
        for (int i = 0; i < n; i++) {
            nums[i] += 50000;
        }

        // Step 2: Set up counting array
        int[] count = new int[k + 1];
        int[] output = new int[n];

        // Step 3: Fill count array
        for (int num : nums) {
            count[num]++;
        }

        // Step 4: Build cumulative count
        for (int i = 1; i <= k; i++) {
            count[i] += count[i - 1];
        }

        // Step 5: Build output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[nums[i]] - 1] = nums[i];
            count[nums[i]]--;
        }

        // Step 6: Shift back to original numbers
        for (int i = 0; i < n; i++) {
            output[i] -= 50000;
        }

        return output;
    }

}
