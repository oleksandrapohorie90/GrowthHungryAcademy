package data_structures_and_algorithms_CS210.Second_Cohort.week20_recurssion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        //We use backtracking, which is a technique to explore all possible solutions by making a choice, exploring further, and then undoing the choice if needed.
        //Time complexity: We use backtracking, which is a technique to explore all possible solutions by making a choice, exploring further, and then undoing the choice if needed.
/**
 * Add 1 → tempList = [1]
 *     Add 2 → tempList = [1,2]
 *         Add 3 → tempList = [1,2,3] ✅ (Save to list)
 *         Remove 3 → tempList = [1,2]
 *     Remove 2 → tempList = [1]
 *     Add 3 → tempList = [1,3]
 *         Add 2 → tempList = [1,3,2] ✅ (Save to list)
 *         Remove 2 → tempList = [1,3]
 *     Remove 3 → tempList = [1]
 * Remove 1 → tempList = []
 */

        int[] arr = {1, 2, 3};
        System.out.println(permute(arr));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(list, tempList, nums);
            tempList.removeLast();
        }
    }
}
