package foundation_pre_course.week10;

public class SingleNumber {
    public static void main(String[] args) {

        int[] xor = {4,1,2,1,2};
        System.out.println(singleNumber(xor));

    }

    public static int singleNumber(int[] nums) {
        //XOR -> either or is true at least 1
        //n=nums.length
        //constant space: O(1)
        //linear time: O(n)
        //quasilinear: O(nlogn)
        //XOR - exclusive OR
        //if only 1 of them is true the result is true, otherwise false
        //0 ^ 0 = 0
        //0 ^ 1 = 1
        //1 ^ 0 = 1
        //1 ^ 1 = 0
        //XOR needs to be complete for every pair
        //[a^b^c^a^b^c^d] will give [d]
        //as a result because 'a's,'b's and 'c's
        //will cancel each other

        //1 ^ 2 ^ 3 ^ 1 ^ 2 ^ 3 ^ 4
        //1: 000 ^ 001 = 001
        //2: 001 ^ 010 = 011
        //3: 011 ^ 011 = 000
        //1: 000 ^ 001 = 001
        //2: 001 ^ 010 = 011
        //4: 011 ^ 100 = 111
        //3: 111 ^ 011 = 100

        int answer = 0;
        for(int x: nums){
            answer = answer ^ x;
        }
        return answer;
    }
}
