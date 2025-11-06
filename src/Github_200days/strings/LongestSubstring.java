package Github_200days.strings;

public class LongestSubstring {
    public static void main(String[] args) {
        String [] strs = {"flower","flow","flight"};

        String str = longestCommonPrefix(strs);
        System.out.println(str);

    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
//strs = ["dog","racecar","car"]
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];

    }
}
