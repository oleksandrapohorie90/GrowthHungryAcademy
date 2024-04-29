package Github_200days.control_flow;

import java.util.Random;

public class GuessIt {
    public static void main(String[] args) {
        //generate a random number that won't incl. 0, will return 1,2,or 3
        //to rename var everywhere Shift+F6
        int randomNum = new Random().nextInt(5) + 1;
        System.out.printf("Generated number is %d", randomNum);

        switch (randomNum){
            case 1:
                System.out.println("The color is RED");
                break;
            case 2:
                System.out.println("The color is BLUE");
                break;
            case 3:
                System.out.println("The color is GREEN");
                break;
            default:
                System.out.println("The color is whatever");
        }


        //if then
//        if (randomNum <= 2) { //1,2,3,4,5,6,7,8
//            System.out.println("The color is red");
//        } else if (randomNum == 2) {
//            System.out.println("The color is green");
//        } else if (randomNum == 3) {
//            System.out.println("The color is purple");
//        } else {
//            System.out.println("The color is whatever");
//        }
        //if then else

    }

}
