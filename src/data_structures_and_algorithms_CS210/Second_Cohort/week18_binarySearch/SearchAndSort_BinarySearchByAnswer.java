package data_structures_and_algorithms_CS210.Second_Cohort.week18_binarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class SearchAndSort_BinarySearchByAnswer {

    /**
     This morning the jury decided to add another Very Easy Problem to the Olympiad version. The responsible secretary of the Organizing Committee printed its conditions in one copy, and now he needs to make N more copies before the Olympiad starts. He has two photocopiers at his disposal, one of which copies a sheet in x seconds, and the other in y . (It is allowed to use either one photocopier or both at the same time. You can copy not only from the original, but also from the copy.) Help him figure out what minimum time is required for this.

     Input data
     The program input contains three natural numbers N , x and y , separated by a space (1 ≤ N ≤ 2∙10 8 , 1 ≤ x , y ≤ 10).

     Output data
     Output a single number - the minimum time in seconds required to obtain N copies.

     Examples
     Input data
     4 1 1
     Output data
     3
     Input data
     5 1 2
     Output data
     4
     */
    // TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    private static class Solution {
        private void run(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

            int left = 0;
            int right = (int) 1e9;
            int answer = -1;
            n--; // First copy will be printed in Math.min(x, y) time. Next copies will utilize both printers.
            while (left <= right) {
                int middle = left + (right - left) / 2;
                // (middle / x) copies on the first printer
                // (middle / y) copies on the second printer
                if (middle / x + middle / y >= n) {
                    answer = middle;
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }

            System.out.println(Math.min(x, y) + answer);
        }
    }

    public static void main(String[] args) {
        // TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
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


