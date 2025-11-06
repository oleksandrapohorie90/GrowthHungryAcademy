package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        int original = x, reversed = 0;
        //original = 121, reversed = 0

        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
            //1. reversed = 0 * 10 + 121%10 = 0 + 1 = 1, then 121/10 = 12
            //2. reversed(1) = 1 * 10 + 12%10 = 10 + 2 = 12, then 12/10=1
            //3. reversed(12) = 12 * 10 + 1%10 = 120 + 1 = 121, then 1/10=0
        }
        return original == reversed;

    }
}
