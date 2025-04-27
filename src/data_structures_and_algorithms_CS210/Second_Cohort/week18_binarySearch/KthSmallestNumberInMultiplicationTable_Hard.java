package data_structures_and_algorithms_CS210.Second_Cohort.week18_binarySearch;

public class KthSmallestNumberInMultiplicationTable_Hard {
    /**
     * Nearly everyone has used the Multiplication Table. The multiplication table of size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed).
     * <p>
     * Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: m = 3, n = 3, k = 5
     * Output: 3
     * Explanation: The 5th smallest number is 3.
     * Example 2:
     * <p>
     * <p>
     * Input: m = 2, n = 3, k = 6
     * Output: 6
     * Explanation: The 6th smallest number is 6.
     */
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        int answer = -1;
        // Observation: The leftmost (the first) value on this interval,
        // for which there are >= k numbers in the mult table
        // less than or equal to it, is the answer.
        //
        // E.g. m=3 x n=3 mult table
        //
        // 1 2 3
        // 2 4 6
        // 3 6 9
        //
        // 1 2 2 3 3 4 6 6 9
        //
        // For 1, there  is 1 number  in the mult table less than or equal to 1.
        // For 2, there are 3 numbers in the mult table less than or equal to 2.
        // For 3, there are 5 numbers in the mult table less than or equal to 3.
        // For 4, there are 6 numbers in the mult table less than or equal to 4.
        // For 5, there are 6 numbers in the mult table less than or equal to 5.
        // For 6, there are 8 numbers in the mult table less than or equal to 6.
        // For 7, there are 8 numbers in the mult table less than or equal to 7.
        // For 8, there are 8 numbers in the mult table less than or equal to 8.
        // For 9, there are 9 numbers in the mult table less than or equal to 9.
        //
        // If k = 5, the answer is 3, i.e. the leftmost (first) number such that it has >= k
        // numbers in the mult table that are less than or equal to it.
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int count = countNumsLessThanOrEqualToValueInMultTableMbyN(middle, m, n);
            if (count >= k) {
                answer = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        // T: O(log(m*n) * m) <-> O(m*n)
        return answer;
    }

    private int countNumsLessThanOrEqualToValueInMultTableMbyN(int value, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            // Observation: In i-th row, I have (value / i) numbers that are <= value.
            // m=5 x n=6 mult table
            //  ________________  if the mult table would beyond boundaries...
            // |1  2  3  4  5  6| ->  7  8  9 10 11 12 13 14 15 16...
            // |2  4  6  8 10 12| -> 14 16 18 20 22 24 26 28 30 32...
            // |3  6  9 12 15 18| -> 21 24 27 30 33 36 39 42 45 48...
            // |4  8 12 16 20 24| -> 28 32 36 40 44 48 52 56 60 64...
            // |5 10 15 20 25 30| -> 35 40 45 50 55 60 65 70 75 80...
            //  ----------------
            // E.g. in 5x6 mult table
            //   * in 1st row (multiples of 1), you have min(15 / 1, 6) = 6 numbers that are <= 15
            //   * in 2nd row (multiples of 2), you have min(15 / 2, 6) = 6 numbers that are <= 15
            //   * in 3rd row (multiples of 3), you have min(15 / 3, 6) = 5 numbers that are <= 15
            //   * in 4th row (multiples of 4), you have min(15 / 4, 6) = 3 numbers that are <= 15
            //   * in 5th row (multiples of 5), you have min(15 / 5, 6) = 3 numbers that are <= 15
            // In total, there are 6 + 6 + 5 + 3 + 3 = 23 numbers (out of 30) that are <= 15
            count += Math.min(value / i, n);
        }
        return count;
    }
}
