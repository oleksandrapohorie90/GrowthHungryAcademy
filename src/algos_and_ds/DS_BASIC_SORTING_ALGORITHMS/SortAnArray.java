package algos_and_ds.DS_BASIC_SORTING_ALGORITHMS;

public class SortAnArray {

    public int[] sortArray(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] += 50000;
        }

        int[] frequency = new int[100001]; //indices 0...100000
        for (int i = 0; i < n; i++) {
            frequency[nums[i]]++;
        }
        for (int i = 1, j = 0; i <= 100000; i++) {
            while (frequency[i] > 0) {
                nums[j] = i;
                frequency[i]--;
                j++;
            }
        }
        for (int i = 0; i < n; i++) {
            nums[i] -= 50000;
        }
        return nums;
    }
}