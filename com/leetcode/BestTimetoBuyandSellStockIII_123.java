package com.leetcode;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimetoBuyandSellStockIII_123 {

	public static void main(String[] args) {
		
		int [] prices = {1,2,3,4,5};
		System.out.println(maxProfit(prices));

	}
	
	
	
	
	private static int  maxProfit(int[] prices) {
		
		// 1.calculate profit from left side left[i]-----left[n]
		// 2. calculate profit from right side  right[n] -----right[0]
		// 3. find maximum profit of left[i] + right[i+1] 
		
		int left[] = new int[prices.length];
		int right[] = new int[prices.length+1];
		left[0] =0;
		int n = prices.length;
		right[n-1] =0;
		
		//1,2,3,4,5
		int min_price=prices[0];
		int max_profit=0;
		for(int i=1;i<n;i++) {
			if(prices[i] < min_price) {
				min_price =prices[i];
			}
			
			if(prices[i] - min_price > max_profit) {
				max_profit=	prices[i] - min_price ;
			}
			
			left[i] = max_profit;
			
		}
		
		 min_price=prices[n-1];
		 max_profit=0;
		for(int i=n-2;i>=0;i--) {
			if(prices[i]> min_price) {
				min_price = prices[i];
			}
			
			if(min_price -prices[i] > max_profit) {
				max_profit = min_price -prices[i];
			}
			
			right[i] = max_profit;
		}
		
		 max_profit=0;
		for(int i=0;i<n;i++) {
			max_profit = Math.max(max_profit, left[i]+right[i+1]);
		}

		return max_profit;
	}




	/*
	 *Below solution leads to TLE , as Time complexity is O(n^3)
	 *here we need to check only 2 transaction 
	 */
	public  static int maxProfit_TLX(int[] prices) {
        int dp[][] = new int[3][prices.length];
    
      for(int i=0;i<=2;i++){
        for(int j=0;j<prices.length;j++){
          
          int max_profit = 0;
          
          if(i==0 || j==0){
            dp[i][j] = 0;
          } 
          else{
            for(int m=0;m<j;m++){
              
             int cur_profit = prices[j] - prices[m] + dp[i-1][m]; //dp[i-1][m] this is previous profit
            
            if(cur_profit >max_profit){
              max_profit = cur_profit;
            }
           }
            dp[i][j] = Math.max(max_profit,dp[i][j-1]);//dp[i][j-1] is without transacting
          }
          
          
          
        }
      }
      
      return dp[2][prices.length-1];
    }

}
