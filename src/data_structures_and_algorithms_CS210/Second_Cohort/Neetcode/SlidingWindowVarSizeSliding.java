package data_structures_and_algorithms_CS210.Second_Cohort.Neetcode;

public class SlidingWindowVarSizeSliding {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices){
            if(price < minPrice){
                minPrice = price;
            }else{
                maxProfit = Math.max(maxProfit,price - minPrice);
            }
        }
        return maxProfit;
    }
}
