package com.leetcode;

/*
 * Find the maximum profit you can achieve. You may complete at most k transactions.
 */

/*
 * Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
        Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class BestTimetoBuyandSellStockIV_188 {

	public static void main(String[] args) {

		int k = 2;
		int[] prices = { 1,2,3,4,5 };
		
		System.out.println(maxProfit(k, prices));

	}

	/*
	 * This is DP based solution 
	 * formula max
	 * 1. not transacting T[i-1][j]
	 * 2. prices[j]-prices[m] + T[i-1][m](previous profit) 
	 * 
	 */
	public static int maxProfit(int k, int[] prices) {
		int T[][] = new int[k+1][prices.length];
		
		for(int i=0;i<=k;i++) {// for each transaction
			for(int j=0;j<prices.length;j++) {
				// profit is 0 when:
                // i = 0, i.e., for 0th day
                // j = 0, i.e., no transaction is being performed
				if(i==0 || j==0) {
					T[i][j] =0;
				}else {
					int max_so_far=0;
					
					for(int m=0;m<j;m++) {
						int cur_profit = prices[j] - prices[m]+T[i-1][m];
						if(cur_profit > max_so_far) {
							max_so_far= cur_profit;
						}
					}
					
					T[i][j] = Math.max(max_so_far, T[i][j-1]);
					}
			}
			
		}

		return T[k][prices.length-1];
	}

}
