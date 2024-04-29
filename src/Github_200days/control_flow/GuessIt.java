package Github_200days.control_flow;

import java.util.Random;

public class GuessIt {
    public static void main(String[] args) {
        //generate a random number that won't incl. 0, will return 1,2,or 3
        //to rename var everywhere Shift+F6
        int randomNum = new Random().nextInt(5) + 1;
        System.out.printf("Generated number is %d", randomNum);

        //if then
        if (randomNum <= 2) { //1,2,3,4,5,6,7,8
            System.out.println("The color is red");
        } else if (randomNum > 4 || (randomNum % 2 == 0)) {
            System.out.println("The color is green");
        } else {
            System.out.println("smth else");
        }
        //if then else

    }

}
