package foundation_pre_course.week10;

import Github_200days.string_string_builder.StringBuilder;

public class ReverseString {
    public static void main(String[] args) {
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(reverseString(arr));
    }

    public static String reverseString(char[] s) {
        //implement 2 pointer idea
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        return new String(s);
    }

    //2
    public static String reverseString2(char[] s) {
        //char[] t = new StringBuilder(new String(s)).reverse().toString().toCharArray();
        //System.arraycopy(t, 0, s, 0, s.length);
        return null;
    }


}
