import java.io.*;
import java.util.StringTokenizer;

public static class Chips_1414 {

    //??
    private InputReader in_;
    private PrintWriter out_;

    private void put(int n) {
        if (n == 1) {
            out_.print("1 ");
            return;
        }
        put(n - 1);
        out_.print(n + " ");
        remove(n - 1);
    }

    private void remove(int n) {
        if (n == 1) {
            out_.print("-1 ");
            return;
        }
        put(n - 1);
        out_.print(-n + " ");
        remove(n - 1);
    }

    public void run(InputReader in, PrintWriter out) {
        in_ = in;
        out_ = out;

        int n = in_.nextInt();
        for (int i = n; i >= 1; i--) {
            put(i);
        }
        out_.println();
    }
}

public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    Chips_1414 solution = new Chips_1414();
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

