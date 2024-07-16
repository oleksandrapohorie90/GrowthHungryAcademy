package data_structures_and_algorithms.Leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class ClosestSubseqSum {
    public int minAbsDifference(int[] nums, int goal)
    {
        //splitting the array , nums, into 2 parts
        int part1[] = new int[nums.length/2];
        int part2[] = new int[nums.length-part1.length];
        int k = 0;
        for(int i=0;i<part1.length;i++)
        {
            part1[i] = nums[i];
            k++;
        }
        for(int i=0 ; i<part2.length ; i++)
        {
            part2[i] = nums[k];
            k++;
        }
        ArrayList<Integer> sum1=new ArrayList<>(); // stores the sum of all subseq of part1
        ArrayList<Integer> sum2=new ArrayList<>(); //stores the sum of all subseq of part2
        //fills sum1 & sum2 ,  i.e add the sum of elements of all possible subseq of part1 into sum1 &
        //add the sum of elements of all possible subseq of part2 into sum2
        addSum(sum1,part1,0,0);
        addSum(sum2,part2,0,0);
        //sorting the two lists
        Collections.sort(sum1);
        Collections.sort(sum2);

        int low  = 0;
        int high = sum2.size()-1;
        int res = Integer.MAX_VALUE;
        while(low < sum1.size() && high >= 0)
        {
            int sum = sum1.get(low)+sum2.get(high);
            res = Math.min(res,Math.abs(sum-goal));
            if(sum > goal)
            {
                high--;
            }
            else if(sum==goal)
            {
                return 0;
            }
            else
            {
                low++;
            }

        }

        return res;
    }
    private void addSum(ArrayList<Integer> sumlist, int[] part, int sum, int si)
    {
        if(si>=part.length)
        {
            sumlist.add(sum);
            return;
        }
        //include
        addSum(sumlist,part,sum+part[si],si+1);
        //exclude
        addSum(sumlist,part,sum,si+1);
    }
}
