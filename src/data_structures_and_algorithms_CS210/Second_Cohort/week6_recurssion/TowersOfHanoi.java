package data_structures_and_algorithms_CS210.Second_Cohort.week6_recurssion;

import java.io.*;
import java.util.StringTokenizer;

public class TowersOfHanoi {
    //classic recursion problem
    //https://informatics.msk.ru/mod/statements/view.php?id=2550#1
    //1st-starting rode
    //2nd-helper rode (auxilary rode)
    //3rd-finish rode
    //but as a sub proble n-1 disks only top 2 ones
    //1st-starting rode
    //2nd-finish
    //3rd-helper rode (auxilary rode)
    //w. 4 disks, move from start(n-1)disks to 2nd auxilary-helper rode

    private static class Solution {
        private void hanoi(int n, int from, int to) {
            if (n == 0) return;
            int aux = (1 + 2 + 3) - (from + to);
            hanoi(n - 1, from, aux);
            System.out.println(n + " " + from + " " + to);
            hanoi(n - 1, aux, to);
        }

        public void run(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            hanoi(n, 1, 3);
        }
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution solution = new Solution();
        solution.run(in, out);
        out.close();
    }

    private static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
