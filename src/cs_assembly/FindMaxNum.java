package cs_assembly;

public class FindMaxNum {

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 5, 90};
        System.out.println(findMax(arr));
    }
     public static int findMax(int[] arr) {

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }


   }
