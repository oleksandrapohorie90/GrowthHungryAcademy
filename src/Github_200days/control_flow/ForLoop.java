package Github_200days.control_flow;

import java.util.Random;

public class ForLoop {

    public static final int MAX_ALLOWED_TRIED = 4;
    public static void main(String[] args) {
        int randomNum = new Random().nextInt(10) + 1;
        System.out.printf("Random number is %d.%n", randomNum);
        String guessedNumText = null;
        int wrongGuessCount = 0;
        //it will execute no mater what at least one time
        do {
            guessedNumText = System.console().readLine("Please guess a num btw 1 and 10: ");
            if (guessedNumText.matches("-?\\d{1,2}")) {
                int guessedNum = Integer.parseInt(guessedNumText);

                if (guessedNum == randomNum) {
                    String tryText = wrongGuessCount == 1 ? "try" : "tries";
                    System.out.printf("The random num was %d. You got it in %d %s %n", randomNum, wrongGuessCount, tryText);
                    return;
                } else {
                    System.out.println("You didnt get it in %n");
                    wrongGuessCount++;
                }
            }
        }
        while (!"q".equals(guessedNumText) && wrongGuessCount <= MAX_ALLOWED_TRIED);
        if(wrongGuessCount>=MAX_ALLOWED_TRIED){
            System.out.println("You've had %d incorrect guesses. The random number is %d"+wrongGuessCount);
        }

    }
}
