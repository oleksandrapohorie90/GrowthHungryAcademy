package cs_assembly;

public class LinearSearch {
    public static void main(String[] args) {

        int [] arr = {44,5,6,77,8,9};
        int target = 44;
        System.out.println(linearSearch(arr,target));
    }

    public static int linearSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target){
                return i; //need only index
            }
        }
        return -1;
    }
}
