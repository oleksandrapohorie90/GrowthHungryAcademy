package data_structures_and_algorithms_CS210.Second_Cohort.week28_Greedy_Algorithms;

public class RadixSort_MaxGap {
    public int maximumGap(int[] nums) {
        for (int digit = 0; digit <= 9; digit++) {
            radixSort(nums, digit);
        }
        int answer = 0;
        for (int i = 1; i < nums.length; i++) {
            answer = Math.max(answer, nums[i] - nums[i - 1]);
        }
        return answer;
    }

    void radixSort(int[] nums, int digit) {
        // digit = 0 <=> sort by the number of ones (10^0) ===> number / 10^0 % 10
        // digit = 1 <=> sort by the number of tens (10^1) ===> number / 10^1 % 10
        // digit = 2 <=> sort by the number of hundreds (10^2) ===> number / 10^2 % 10
        // ... ===> number / 10^digit % 10
        int power = 1;
        for (int i = 1; i <= digit; i++) {
            power *= 10;
        }
        int[] count = new int[10]; // 0..9
        for (int num : nums) {
            int value = num / power % 10;
            count[value]++;
        }
        int[] pref_sum = new int[10];
        pref_sum[0] = count[0];
        for (int i = 1; i <= 9; i++) {
            pref_sum[i] = pref_sum[i - 1] + count[i];
        }
        int[] sorted = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int value = nums[i] / power % 10;
            pref_sum[value]--;
            sorted[pref_sum[value]] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sorted[i];
        }
    }
}
