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
        String [] expr = row_expr.split(" ");
        if(expr.length != 3){
            throw new IllegalArgumentException("Input doesn't satisfy language rules "+expr);

        }
        try {
            String operator = expr[0];
            int operand1 = Integer.parseInt(expr[1]);
            int operand2 = Integer.parseInt(expr[2]);

        }catch(Exception e){
            throw new IllegalArgumentException("We couldn't parse your input",e);
        }

        scanner.close();
    }
}
