package data_structures_and_algorithms_CS210.Second_Cohort.week6_recurssion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    // nums = [1, 2, 3]

    // Layer #0 (tempList):
    // Layer #0 (iterator i):

    // Layer #1 (tempList):
    // Layer #1 (iterator i):

    // Layer #2 (tempList):
    // Layer #2 (iterator i):

    // Layer #3 (tempList):   [2, 3, 1]
    // Layer #3 (list): [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {
                continue; // element already exists, skip
            }
            tempList.add(nums[i]);
            backtrack(list, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}
