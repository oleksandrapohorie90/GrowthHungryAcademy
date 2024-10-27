package office_hours;

public class Task1 {
    // [2,7,100] => [ 700, 200, 14 ]
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) { //O(n)
            int product = 1;                   //=> O(n^2) the bigger n, the slower algorithm will run
            for (int j = 0; j < n; j++) { //O(n)
                if (i == j) continue;
                product *= nums[j];
            }
            res[i] = product;
        }
        return res;
    }

    //O(n)
    public int[] productExceptSelfO_n(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int product = 1;
        //main point that its not nested loops so its 2 * O(n) NOT O(n^2)
        for (int i : nums) { //one time through array
            product *= i;
        }
        for (int i = 0; i < n; i++) { //we divide 1 on current element
            res[i] = product / nums[i]; //issue we cant divide by 0
        }
        return res;
    }

    //without dividing by 0 and also 2 O(n)
//    public int[] productExceptSelfO_n(int[] nums) {
//
//    }
}

