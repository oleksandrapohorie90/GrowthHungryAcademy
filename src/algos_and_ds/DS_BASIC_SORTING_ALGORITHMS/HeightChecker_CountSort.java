package algos_and_ds.DS_BASIC_SORTING_ALGORITHMS;

public class HeightChecker_CountSort {

    public int heightChecker(int[] heights) {//count sort
        int n = heights.length;
        int[] sorted_copy = new int[n];
        for (int i = 0; i < n; i++) {
            sorted_copy[i] = heights[i];
        }
        int[] frequency = new int[10]; //indices 0...100
        for (int i = 0; i < n; i++) {
            frequency[sorted_copy[i]]++;
        }
        for (int i = 1, j = 0; i <= 100; i++) {
            while (frequency[i] > 0) {
                sorted_copy[i] = i;
                frequency[i]--;
                j++;
            }
        }

        int asnwer = 0;
        for (int i = 0; i < n; i++) {
            if (sorted_copy[i] != heights[i]) {
                asnwer++;
            }
        }
        return asnwer;
    }
}
