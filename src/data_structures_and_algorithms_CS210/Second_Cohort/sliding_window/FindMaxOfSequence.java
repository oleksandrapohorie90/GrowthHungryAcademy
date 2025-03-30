package data_structures_and_algorithms_CS210.Second_Cohort.sliding_window;

public class FindMaxOfSequence {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        System.out.println(maxSum(arr,k));
    }
    public static int maxSum(int[] nums, int k) {
        int windowSum = 0;
        int maxSum = 0;

        // First window of size k
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;

        // Slide the window
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k]; // Add new, remove old
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

}
