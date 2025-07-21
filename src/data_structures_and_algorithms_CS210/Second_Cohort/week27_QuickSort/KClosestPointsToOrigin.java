package data_structures_and_algorithms_CS210.Second_Cohort.week27_QuickSort;

import java.util.Random;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;

        int[][] dist_index = new int[n][2];
        for (int i = 0; i < n; i++) {
            dist_index[i][0] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            dist_index[i][1] = i;
        }

        quickSelect(dist_index, 0, n - 1, k - 1);

        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            answer[i] = points[dist_index[i][1]];
        }
        return answer;
    }

    private static void quickSelect(int[][] arr, int left, int right, int k) {
        // Take a random pivot from the whole range.
        Random rand = new Random();
        int randIndex = rand.nextInt(left, right + 1);
        swap(arr, left, randIndex);

        int pivot = arr[left][0];
        int storeIndex = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i][0] < pivot) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }
        swap(arr, left, storeIndex - 1);
        int l = storeIndex - 2;
        int r = storeIndex;
        while (l >= left && arr[l][0] == pivot) l--;
        while (r <= right && arr[r][0] == pivot) r++;

        if (l + 1 <= k && k <= r - 1) return;
        if (k <= l) quickSelect(arr, left, l, k);
        else quickSelect(arr, r, right, k);
    }

    private static void swap(int[][] arr, int i, int j) {
        int[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
