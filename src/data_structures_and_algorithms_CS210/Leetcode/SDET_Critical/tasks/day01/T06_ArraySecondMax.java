package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical.tasks.day01;

//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;

public class T06_ArraySecondMax {
    public int findSecondLargest(int[] arr) {
        if (arr.length < 2) return -1;

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }

//    @Test
//    public void test() {
//        System.out.println(findSecondLargest(new int[] {32,54,65,23,11,98}));
//        Assertions.assertEquals(65, findSecondLargest(new int[] {32,54,65,23,11,98}));
//    }

}
