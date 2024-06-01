package cs_assembly.week12;

import java.util.Scanner;

public class CalculatorDSL {
    /**
     * extend our DEMO to support
     * - 9.5.1 Decimals
     * - 9.5.2 MOD operation (%)
     * - 9.5.3 POW operation (^)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String row_expr = scanner.nextLine();
        String[] expr = row_expr.split(" ");
        if (expr.length != 3) {
            throw new IllegalArgumentException("Input doesn't satisfy language rules " + expr);

        }
        try {
            String operator = expr[0];
            int operand1 = Integer.parseInt(expr[1]);
            int operand2 = Integer.parseInt(expr[2]);
            int result = evaluate(operator, operand1, operand2);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }

    private static int evaluate(String operator, int operand1, int operand2) {
        switch (operator) {
            case "ADD":
                return operand1 + operand2;
            case "SUB":
                return operand1 - operand2;
            default:
                throw new IllegalArgumentException("Unsupported operation" + operator);
        }

    }
}
