package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical;

public class ReverseStringNoBuiltInFunction {

    public static void reverseString(char[] charArr) {

        int left = 0;
        int right = charArr.length - 1;

        while (left < right) {
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;
            left++;
            right--;
        }

    }
}
