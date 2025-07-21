package data_structures_and_algorithms_CS210.Second_Cohort.week27_QuickSort;

import java.util.Random;

public class SortAnArray {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
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
        while (l >= left && arr[l] == pivot) l--;
        quickSort(arr, left, l);
        int r = storeIndex;
        while (r <= right && arr[r] == pivot) r++;
        quickSort(arr, r, right);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
