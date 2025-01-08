package foundation_pre_course.week10;

public class BestTimeToBuyAndSellStock {
    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     *
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     *
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     *
     *
     *
     * Example 1:
     *
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     * Example 2:
     *
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transactions are done and the max profit = 0.
     */
/*
lets iterate from left to right and when we see the current price
buy on the prev day when the price was lower and I want to sell it today
You start with lowest price so far, start with min price
*Buy on the previous day where the price was minimum and you sell today
 if today is price $6, then you sell it for min price that you saw in the past $1
 Input: prices = [7,1,5,3,6,4]
 I start w/ day 2 = $1, my min price in the past is $7, so I actually loose
 I continue w/ day 3 = $5, my min price btw $7 and $1 is $1 in the past, so profit is $4(5-1)
 I continue w/ day 4 = $3, my min price btw $7 and $1 and $5 is $1 in the past, so profit is $2(3-1), but we've seen $4 in profit so we skip this day and continue
I continue w/ day 5 = $6, my min price btw $7 and $1 and $5 $3 is still $1 in the past, so profit is $5(6-1) and thats the highest Ive seen so far, so I continue
 */
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices){
        int lowest_price_so_far = prices[0];
        int highest_profit = 0;

        for(int todays_price : prices){
            highest_profit = Math.max(highest_profit,todays_price-lowest_price_so_far);
            lowest_price_so_far = Math.min(todays_price,lowest_price_so_far);
        }
        return highest_profit;
    }
}
