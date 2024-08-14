package data_structures_and_algorithms.week14;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;
        int n = A.length;

        while (i < n && j < n) {
            //find the next odd int at tan even position
            while (i < n && A[i] % 2 == 0) {
                i += 2;
            }

            //find the next even int at an odd position
            while (j < n && A[j] % 2 == 1) {
                j += 2;
            }

            //if both found, swap them
            if (i < n && j < n) {
                swap(A, i, j);
            }
        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
