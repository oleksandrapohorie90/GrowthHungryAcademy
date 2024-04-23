package Github_200days.numbers;

import java.util.Random;

public class RandomClass {
    public static void main(String[] args) {
        //you can supply a seed, like sample bound
        Random random = new Random();
        //from 0 up to 9
        System.out.println(random.nextInt(10));
        //from 0 up to 10000
        System.out.println(random.nextInt(10000));
        System.out.println();
        System.out.println();
        System.out.println();
    }


}
