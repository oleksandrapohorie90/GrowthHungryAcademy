package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical;

public class ReverseStringNoBuiltInFunction {
    public static String reverseString(String str) {
        StringBuilder stb = new StringBuilder(str);
        return stb.reverse().toString();
    }

    public static String reverseStr(String str) {
        //String reversed = "";
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--) {
            //reversed += str.charAt(i);
            reversed.append(str.charAt(i));
        }
        return  reversed.toString();
    }
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
