package java_intro.week6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuickSort {
    /**
     * Create a generic sorting algorithm (e.g. quicksort) that can sort lists of various data types,
     * allowing users to specify a custom comparator to define the sorting order. The algorithm
     * should be efficient and handle different edge cases.
     */
    public static <T> void sort(List<T> list, Comparator<T> comparator) {

        //to Implement
        if (list == null || list.size() <= 1) return; // No sorting needed for null or single-element lists
        quicksort(list, comparator, 0, list.size() - 1);
    }

    // Recursive quicksort method
    private static <T> void quicksort(List<T> list, Comparator<T> comparator, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(list, comparator, start, end); // Partition the list and get pivot index
            quicksort(list, comparator, start, pivotIndex - 1); // Sort left half
            quicksort(list, comparator, pivotIndex + 1, end);   // Sort right half
        }
    }

    // Partition method: divides the list based on the pivot
    private static <T> int partition(List<T> list, Comparator<T> comparator, int start, int end) {
        T pivot = list.get(end);  // Use the last element as the pivot
        int i = start; // i will track where we put elements smaller than the pivot

        for (int j = start; j < end; j++) {
            if (comparator.compare(list.get(j), pivot) < 0) { // If current element is smaller than pivot
                swap(list, i, j); // Place it before the pivot
                i++;
            }
        }
        swap(list, i, end); // Move pivot to its correct position
        return i;
    }

    // Swap method to exchange elements at two indexes
    private static <T> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(3);
        intList.add(1);
        intList.add(4);
        intList.add(2);
    // Sort by natural order
        sort(intList, Comparator.naturalOrder());
        System.out.println("Sorted integer list: " + intList);
        List<String> stringList = new ArrayList<>();
        stringList.add("Charlie");
        stringList.add("Alice");
        stringList.add("Bob");
    // Sort by custom comparator (e.g., descending order)
        sort(stringList, Comparator.comparing(String::length).reversed());
        System.out.println("Sorted string list (descending order): " + stringList);
    }

}
