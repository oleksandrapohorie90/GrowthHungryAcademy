package cs_and_programming.week_6;

import java.util.Arrays;

public class JavaReverseAnArray {
    public static void main(String[] args) {
        int [] arr = {55,3,2,3,8,9};
        System.out.println(Arrays.toString(rotateArray(arr)));
    }

    public static int[] rotateArray(int [] arr){
        int[] result = new int[arr.length];
        int index = 0;

        for(int i=arr.length-1;i>=0; i--){
            result[index] = arr[i];
            index++;
        }
        return result;
    }
}
