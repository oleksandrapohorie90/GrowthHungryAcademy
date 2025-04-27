package data_structures_and_algorithms_CS210.Second_Cohort.week22_Stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Rails {

    //basecamp.eolymp.com/en/problems/1776
    private static class Solution {
        public void run(InputReader in, PrintWriter out) {
            while (true) {
                int n = in.nextInt(); // 0 or n
                if (n == 0) break;

                while (true) {
                    int x = in.nextInt(); // 0 or a[1]
                    if (x == 0) break;

                    int current = 1;
                    boolean success = true;
                    Stack<Integer> s = new Stack<>();
                    for (int i = 2; i <= n; i++) {
                        if (success) {
                            for (; current <= x; current++) {
                                s.push(current);
                            }
                            if (s.peek() != x) {
                                success = false;
                            } else {
                                s.pop();
                            }
                        }
                        x = in.nextInt(); // a[i], 2 <= i <= n
                    }
                    System.out.println(success ? "Yes" : "No");
                }
                System.out.println();
            }
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
