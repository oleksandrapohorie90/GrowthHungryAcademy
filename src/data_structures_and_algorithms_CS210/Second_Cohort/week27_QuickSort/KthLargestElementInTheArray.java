package data_structures_and_algorithms_CS210.Second_Cohort.week27_QuickSort;

import java.util.Random;

public class KthLargestElementInTheArray {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] arr, int left, int right, int k) {
        // Take a random pivot from the whole range.
        Random rand = new Random();
        int randIndex = rand.nextInt(left, right + 1);
        swap(arr, left, randIndex);

        int pivot = arr[left];
        int storeIndex = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }
        swap(arr, left, storeIndex - 1);
        int l = storeIndex - 2;
        int r = storeIndex;
        while (l >= left && arr[l] == pivot) l--;
        while (r <= right && arr[r] == pivot) r++;

        if (l + 1 <= k && k <= r - 1) return arr[k];
        if (k <= l) return quickSelect(arr, left, l, k);
        return quickSelect(arr, r, right, k);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
