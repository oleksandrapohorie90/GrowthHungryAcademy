package Github_200days.control_flow;

import java.util.Random;

public class WhileLoop {
    //to open terminal Alt+F12
    //to run java code in terminal -> java -cp out/production/Github_200days/control_flow WhileLoop
    public static void main(String[] args) {
        int randomNum = new Random().nextInt(10)+1;
        String guessedNumText = System.console().readLine("please guess a num btw 1 and 10");
        int guessedNum = Integer.parseInt(guessedNumText);

        if(guessedNum==randomNum) {
            System.out.printf("The randowm num was %d. You got it!%n", randomNum);
        }else{
            System.out.printf("The random number was %d.You didn't get it",randomNum);
        }
        }
    }

