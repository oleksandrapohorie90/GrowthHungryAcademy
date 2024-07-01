package cs_and_programming.week_3;

public class IsSortedArray {

    public static void main(String[] args) {
    int [] arr = {1,2,3,4,555,6};

        System.out.println(isSorted(arr));
    }

    public static boolean isSorted(int [] arr){

        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
        }

}
