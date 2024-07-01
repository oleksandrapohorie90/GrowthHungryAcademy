package cs_and_programming.week_6;

public class JavaSumAnArray {

    public static void main(String[] args) {
        int [] arr = {55,3,2,3,8,9};
        System.out.println(sumArray(arr));
    }
    public static int sumArray(int[] arr){

        int sum = 0;

        for (int j : arr) {

            sum += j;
        }
        return sum;
    }

    public int[] runningSum(int[] nums) {

        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i-1]+nums[i];

        }
        return nums;

    }
}
