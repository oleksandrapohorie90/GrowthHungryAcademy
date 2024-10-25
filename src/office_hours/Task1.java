package office_hours;

public class Task1 {
// [2,7,100] => [ 700, 200, 14 ]
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                product *= nums[j];
            }
            res[i] = product;
        }
        return res;
    }
}

