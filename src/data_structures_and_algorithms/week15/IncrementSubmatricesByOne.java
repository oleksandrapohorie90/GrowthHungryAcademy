package data_structures_and_algorithms.week15;

public class IncrementSubmatricesByOne {

    public int[][] rangeAddQueries(int n, int[][] queries) {
        //create a bigger array, so that I dont have to care about going out of bounds in any computations
        int[][] a = new int[n + 2][n + 2];

        for (int[] query : queries) {
            //add 1 to all indicies to make the array and queries 1-indexed
            int r1 = query[0] + 1, c1 = query[1] + 1;
            int r2 = query[2] + 1, c2 = query[3] + 1;

            //apply _1 on a [r1...n][c1..n]
            a[r1][c1] += 1;
            //undo +1 on a [r2+1...n][c1..n]
            a[r2 + 1][c1] -= 1;
            //undo +1 on a [r1][c2+1..n]
            a[r1][c2 + 1] -= 1;

            //apply +1 on a [r2+1...n] bc +1 was undone twice(-2)
            a[r2 + 1][c2 + 1] += 1;
        }
        //compute 2d prefix sums, i.e the final array
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                a[r][c] = (a[r - 1][c] + a[r][c - 1] - a[r - 1][c - 1]) + a[r][c];
            }
        }
        //the problem requires returning a strictly n x n array
        //[my array 'a' is (n+2)x(n+2), so I copy results to this array 'r'
        //that i will return
        int[][] r = new int[n][n];
        for (int i = 0; i < n; i++) {//O(N^2)
            for (int j = 0; j < n; j++) {
                r[i][j] = a[i + 1][j + 1];
            }
        }
        return r;
    }
}

