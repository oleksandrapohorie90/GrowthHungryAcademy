package data_structures_and_algorithms_CS210.Leetcode.Arrays;

public class RangeSumQueryImmutable_PrefixSum {
    int[] prefix;

    // arr was 1-indexed, but nums is 0-indexed.
    public RangeSumQueryImmutable_PrefixSum(int[] nums) {
        int n = nums.length;
        // `prefix` array is 1-indexed because it greatly simplifies computations.
        // If `prefix` array would be 0-indexed, we'd have to always consider the case
        // when i = 0 or left = 0 separately, so that we don't go out-of-bounds.
        prefix = new int[n + 1]; // prefix[0 .. n]
        // 0 1 2 3 4 5
        // nums = [-2, 0, 3, -5, 2, -1]
        // 0 1 2 3 4 5 6
        // prefix = [ 0, -2, -2, 1, -4, -2, -3]
        // prefix[0] = 0 because it is semantically equal to an empty prefix (which has zero
        // sum).
        // 1. 2. 3.
        // 4. 5. 6. 7.
        // 8. 9. 10. 11. 12.
        // 13. 14. 15.
        // 16. 17. 18.
        // 19. 20. 21. 22. 23. 24. 25. 26.
        // 27. 28. }
        // 29. }
        // 30.
        // 31. 32. 33. 34.
        // 35. 36. 37. 38. 39. 40. 41. }
        // 42. }
        // 43.
        // 44. 45. 46.

        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            // prefix[i] =
            // sum(nums[1 .. i - 1]) +
            // nums[i]
            prefix[i] = prefix[i - 1] + nums[i - 1];
            // nums[i - 1] (not nums[i]) because `nums` array is 0-indexed.
        }
    }

    public int sumRange(int left, int right) {
        // Increment by 1 because `prefix` array is 1-indexed.
        left++;
        right++;
        // nums[left] + ... nums[right]
        // =
        // sum(nums[1 .. right]) -
        // sum(nums[1 .. left - 1]) =
        // sum(nums[left .. right])
        return prefix[right] - prefix[left - 1];
    }
}

