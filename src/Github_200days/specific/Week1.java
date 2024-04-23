package Github_200days.specific;

import java.util.Scanner;

public class Week1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hisName;
        do {
            System.out.print("Please enter the first name of the person you would love to know about : ");
            hisName = sc.next();
            if (hisName.equals("")) {
                System.out.print(hisName);
            }
        } while (!hisName.equals(""));
    }
}
