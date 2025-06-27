package data_structures_and_algorithms_CS210.Second_Cohort.Neetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {

    class Pair {
        int key;
        String value;

        Pair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // Implementation of Insertion Sort
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        int n = pairs.size();
        List<List<Pair>> res = new ArrayList<>();  // To store the intermediate states of the array

        for (int i = 0; i < n; i++) {
            int j = i - 1;

            // Move elements that are greater than key one position ahead
            while (j >= 0 && pairs.get(j).key > pairs.get(j + 1).key) {
                Pair temp = pairs.get(j);
                pairs.set(j, pairs.get(j + 1));
                pairs.set(j + 1, temp);
                j--;
            }

            // Clone and save the entire state of the array at this point
            List<Pair> cloneList = new ArrayList<>(pairs);
            res.add(cloneList);
        }
        return res;
    }
}
