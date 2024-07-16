package data_structures_and_algorithms.week8;

import java.util.Scanner;

public class Hashing {
    /**
     * Given a string and a pattern, your task is to count the number of positions where the pattern occurs in the string.
     * Input
     * The first input line has a string of length n, and the second input line has a pattern of length m. Both of them consist of characters a–z.
     * Output
     * Print one integer: the number of occurrences.
     * Constraints
     * <p>
     * 1 \le n,m \le 10^6
     * <p>
     * Example
     * Input:
     * saippuakauppias
     * pp
     * <p>
     * Output:
     * 2
     */

    public static int[] countPattern(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int length = 0;  // Length of the previous longest prefix suffix
        int i = 1;

        // Loop to fill the lps array
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // Function to count occurrences of the pattern in the text using Knuth-Morris-Pratt (KMP) algorithm
    public static int kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] lps = countPattern(pattern);

        int i = 0;  // Index for text
        int j = 0;  // Index for pattern
        int count = 0;  // Count of pattern occurrences

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                count++;  // Found a match
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input string
        String text = scanner.nextLine().trim();
        // Read the pattern string
        String pattern = scanner.nextLine().trim();

        // Perform KMP search and count the occurrences
        int result = kmpSearch(text, pattern);

        // Print the result
        System.out.println(result);

        scanner.close();
    }
}



