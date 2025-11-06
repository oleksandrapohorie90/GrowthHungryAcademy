package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical;

import java.util.Random;

public class GenerateRandomNumBtw1And100 {
    public static int generateRandomNum() {
        return new Random().nextInt(1, 101);
        //return new Random().nextInt(100)+1;
    }
}
