package algos_and_ds;

import java.util.Scanner;

public class Hashcode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String t = in.nextLine();

        int n = s.length();
        int m = t.length();

        long p = 9973;
        long mod = (long)1e0+7;

        //first compute the hash of pattern String t
        long h_t=0;
        for (int i = 0; i < m; i++) {
            long c = t.charAt(i); //ASCII code of the current char
            h_t = (h_t*p+c)%mod;
        }

        //second compute hashes of each prefix of str String s
        long [] h_s = new long[];


    }
}
