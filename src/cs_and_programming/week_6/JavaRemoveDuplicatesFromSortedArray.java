package cs_and_programming.week_6;

import java.util.Arrays;

public class JavaRemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {

        int[] arr = {2,2,3,3,4,6,6};
        //to print with duplicates
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+" ");
        }
        System.out.println();

        //print without 1st option with more memory
        removeDuplicatesAndSort(arr);

        //to print without duplicates
        int rd = removeDuplicates(arr);
        System.out.println();

        for (int i = 0; i < rd; i++) {
            System.out.println(arr[i]+" ");
        }
    }

    public static void removeDuplicatesAndSort(int[] arr) {

        //sort any input array
        Arrays.sort(arr);

        //create a new arr for storing non-duplicate values
        int [] temp = new int[arr.length];
        int j = 0;

        //loop through to find duplicates and remove
        for (int i = 0; i < arr.length - 1; i++) { //in this case arr.length - 1; is to not get out of bound error, will have to take care of the last element
            if (arr[i] != arr[i + 1]) {
                temp[j++] = arr[i]; //1 is compared with 2, then 2 and 2, then 3 and 4, 4 and 4
            }
        }
        //to check the very last element in the arr
        temp[j++] = arr[arr.length-1];

        //to print only unique elements, we know till index j there are only unique
        for (int k = 0; k < j; k++) {
            System.out.println(temp[k]);
        }
    }

    //Optimal for memory - https://www.youtube.com/watch?v=I0vmCnkcGW4
    public static int removeDuplicates(int[]arr){
        int rd=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[rd]!=arr[i]){
                rd++;
                arr[rd]=arr[i];
            }
        }
        //rd will be at index 3 but we will return 4
        return rd+1;
    }
}
