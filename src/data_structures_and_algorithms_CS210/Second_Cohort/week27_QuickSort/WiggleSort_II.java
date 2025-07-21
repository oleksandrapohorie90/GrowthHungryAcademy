package data_structures_and_algorithms_CS210.Second_Cohort.week27_QuickSort;

import java.util.Arrays;
import java.util.Random;

public class WiggleSort_II {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n == 1) return;

        int middle = (n + 1) / 2;
        int[] copy = Arrays.copyOf(nums, n);

        // Partition the elements, so that numbers that are <= median
        // are in the left half and numbers that are > median
        // are in the right half.
        int median = quickSelect(copy, 0, copy.length - 1, middle);

        /*
            To get Wiggle Sort, you want to put the numbers in the following way such that:
            (1) elements smaller than the 'median' are put into the even indices,
                starting from the last even index;
            (2) elements larger than the 'median' are put into the odd indices,
                starting from the first odd index;
            (3) the medians are put into the remaining indices.
        */

        // Assign all numbers in `nums` to -1 (an 'invalid' value).
        for (int i = 0; i < n; i++) {
            nums[i] = -1;
        }

        int last_even_index = n - 1;
        if (last_even_index % 2 == 1) last_even_index--;

        // (1) Put numbers that are < median at even indices,
        // starting from the last even index.
        int j = last_even_index;
        for (int i = middle - 1; i >= 0; i--) {  // i iterates over numbers copy[i] <= median (left half)
            if (copy[i] < median) {
                nums[j] = copy[i];
                j -= 2;
            }
        }
        // (2) Put numbers that are > median at odd indices,
        // starting from the first odd index.
        j = 1;
        for (int i = n - 1; i >= middle; i--) {  // i iterates over numbers copy[i] >= median (right half)
            if (copy[i] > median) {
                nums[j] = copy[i];
                j += 2;
            }
        }
        // (3) Remaining indices with 'invalid' values should be assigned to `median` value.
        for (int i = 0; i < n; i++) {
            if (nums[i] == -1) {
                nums[i] = median;
            }
        }
    }

    // Partition the elements and determine what is the number at index k
    // in the sorted order in O(N). The elements are partitioned so
    // that numbers less than the number at index k in the sorted order
    // are to the left of index k, and numbers greater than it are to the
    // right of index k.
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
