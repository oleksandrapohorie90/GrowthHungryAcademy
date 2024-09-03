package data_structures_and_algorithms_CS210.week14;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0; //i iterates over even indices (0, 2, 4, ...).
        int j = 1; //j iterates over odd indices (1, 3, 5, ...).
        int n = A.length;

        while (i < n && j < n) {//here untill both i and j less then length of the array - A

            //find the next odd int at an even position
            while (i < n && A[i] % 2 == 0) {
                //Keep moving i forward while A[i] is even correctly describes that we are skipping over even numbers until we find an odd number at an even index.
                i += 2;//number which is at even position which but which is odd
            }

            //find the next even int at an odd position
            while (j < n && A[j] % 2 == 1) {
                //Keep moving j forward while A[j] is odd" correctly describes that we are skipping over odd numbers until we find an even number at an odd index.
                j += 2;
            }

            /**
             * NOTE:
             * Why i += 2 and j += 2?:
             *
             * i += 2: The variable i is used to iterate over even indices. By incrementing i by 2, you ensure that i only points to even indices. For example, if i starts at 0, i += 2 moves i to 2, then to 4, and so on. This ensures you're only checking and modifying even-indexed positions.
             * j += 2: Similarly, the variable j is used to iterate over odd indices. By incrementing j by 2, you ensure that j only points to odd indices. If j starts at 1, j += 2 moves j to 3, then to 5, and so on. This ensures you're only checking and modifying odd-indexed positions.
             */

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
