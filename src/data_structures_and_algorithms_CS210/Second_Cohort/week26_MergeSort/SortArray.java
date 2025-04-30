package data_structures_and_algorithms_CS210.Second_Cohort.week26_MergeSort;

public class SortArray {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {  // base case: a single element is already sorted
            return;
        }
        //divide arr and recurse
        //Compute the midpoint
        //
        //Call mergeSort on the left half
        //
        //Call mergeSort on the right half
        int middle = (left + right) / 2;
        mergeSort(arr, left, middle); //sort the left half
        mergeSort(arr, middle + 1, right); //sort the right half

        //merge the sorted left and right parts back into one sorted array.
        merge(arr, left, middle, right);
    }

    //worker that combines 2 sorted halves
    public static void merge(int[] arr, int left, int mid, int right) {
        //Calculate the size of the segment we are merging
        //
        //Create a temporary array to store merged elements
        // Setup three pointers:
        //
        //i for the left half (arr[left..mid])
        //
        //j for the right half (arr[mid+1..right])
        //
        //k for the position in the temporary array

        //arr[2], arr[3], arr[4], arr[5] -> how many elements: right - left + 1 = 5 - 2 + 1 = 4(bc zero indexed)
        //It's because you're counting how many total elements are between two indexes inclusive.
        //“How many elements from index left to index right, including both ends?”
        //Count of days from March 3 to March 6 = 6 - 3 + 1 = 4 days
        int len = right - left + 1;
        int[] tmp = new int[len];

        int i = left;       // pointer for left half
        int j = mid + 1;    // pointer for right half
        int k = 0;          // pointer for tmp[]

        //Compare arr[i] and arr[j]
        //
        //Copy the smaller one into tmp[k]
        //
        //Move the corresponding pointer (i or j)
        //
        //Always advance k
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[k] = arr[i];
                i++;
            } else {
                tmp[k] = arr[j];
                j++;
            }
            k++;
        }


    }
}
