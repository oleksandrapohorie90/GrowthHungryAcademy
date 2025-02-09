package data_structures_and_algorithms_CS210.Second_Cohort.week4_binarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class SearchAndSort_BinarySearchByAnswer {

    /**
     * Сегодня утром жюри решило добавить в вариант олимпиады еще одну, Очень Легкую Задачу. Ответственный секретарь Оргкомитета напечатал ее условие в одном экземпляре, и теперь ему нужно до начала олимпиады успеть сделать еще N копий. В его распоряжении имеются два ксерокса, один из которых копирует лист за х секунд, а другой – за y. (Разрешается использовать как один ксерокс, так и оба одновременно. Можно копировать не только с оригинала, но и с копии.) Помогите ему выяснить, какое минимальное время для этого потребуется.
     * <p>
     * Входные данные
     * На вход программы поступают три натуральных числа N, x и y, разделенные пробелом (1 ≤ N ≤ 2∙108, 1 ≤ x, y ≤ 10).
     * <p>
     * Выходные данные
     * Выведите одно число – минимальное время в секундах, необходимое для получения N копий.
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


