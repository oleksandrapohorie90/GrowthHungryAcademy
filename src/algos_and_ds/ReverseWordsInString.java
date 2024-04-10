package algos_and_ds;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        // Remove beg and end spaces from the input string
        String str = s.trim();
        // Split the string by one or more spaces
        String[] arr = str.split("\\s+");

        String res = "";
        // Iterate over the words array in reverse order
        for (int i = arr.length - 1; i >= 0; i--) {
            res += arr[i];
            if (i > 0) {
                res += " ";
            }
        }

        return res;
    }
}
