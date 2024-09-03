package data_structures_and_algorithms_CS210.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int index) {
        if (index == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        // Skip nums[index], don't add it to tempList
        backtrack(list, tempList, nums, index + 1);

        // Add nums[index] to current subset and generate all of the possible subsets with numbers nums[index+1 .. nums.length-1]
        // where nums[index] is present
        tempList.add(nums[index]);
        backtrack(list, tempList, nums, index + 1);
        tempList.remove(tempList.size() - 1);
    }
}
