package Github_200days.control_flow;

import java.util.Random;

public class DoWhileLoop {
    public static void main(String[] args) {
        int randomNum = new Random().nextInt(10) + 1;
        String guessedNumText = null;
        int wrongGuessCount = 0;
        //it will execute no mater what at least one time
        do {
            guessedNumText = System.console().readLine("Please guess a num btw 1 and 10: ");
            if (guessedNumText.matches("-?\\d{1,2}")) {
                int guessedNum = Integer.parseInt(guessedNumText);

                if (guessedNum == randomNum) {
                    System.out.printf("The randowm num was %d. You got it!%n", randomNum);
                    return;
                } else {
                    wrongGuessCount++;
                    System.out.printf("You didn't get it");
                }
            }
        }
        while (!"q".equals(guessedNumText));

    }
}
