package data_structures_and_algorithms_CS210.Leetcode;

import java.util.Scanner;

public class Hashcode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String t = in.nextLine();

        int n = s.length();
        int m = t.length();

        long p = 9973;
        long mod = (long) 1e0 + 7;

        //first compute the hash of pattern String t
        long h_t = 0;
        for (int i = 0; i < m; i++) {
            long c = t.charAt(i) - 'a'; //ASCII code of the current char, sub 97
            h_t = (h_t * p + c) % mod;
        }

        //second compute hashes of each prefix of str String s
        long[] h_s = new long[n];
        h_s[0] = s.charAt(0)-'a';
        for (int i = 1; i < n; i++) {
            long c = s.charAt(i) - 'a';
            h_s[i] = (h_s[i - 1] * p + c) % mod;
        }

        //compute (p^m)%mod
        long p_m = 1;
        for (int i = 0; i < m; i++) {
            p_m = p_m * p % mod;
        }

        int answer = 0;

        //compare each m consecutive chars from str w/ pattern
        //starting at prefix of length m
        for (int i = m - 1; i < n; i++) {
            long h = h_s[i];
            if (i > m - 1) {
                //when you have two nums a and b and you want to compute (a-b) %mod
                //you actually need to compute (a-b+mod)%mod
                h = (h - h_s[i - m] * p_m % mod + mod) % mod;
            }
            if (h == h_t) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
