package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange_322 {

	public static void main(String[] args) {
		int []nums= {2,7,15};
		int target = 11;
		
//System.out.println(findCombination(nums,target));// leads to TLE

//System.out.println(getCountOfCombination(nums, target, nums.length));

System.out.println(coinChange(nums, target));
	}
	
	 public static int coinChange(int[] coins, int amount) {
		 
		 int dp[] = new int[amount+1];
		 
		 Arrays.fill(dp, amount+1);
		 
		 dp[0] =0;
		 
		 for(int sum=1;sum<=amount;sum++) {
			 for(int coin:coins) {
				 if(sum - coin < 0 ) continue;
				 
				 dp[sum] = Math.min(dp[sum], dp[sum - coin]+1);
			 }
		 }
		 
		 
		 return dp[amount] == (amount+1)?-1:dp[amount];
	 }
	
	public static int getCountOfCombination(int [] coins, int sum,int n) {
		
		int [][]dp = new int [sum+1][n+1];
		
		for(int i=0;i<=sum;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0) {
					dp[i][j] =1;
				}
				else if(j==0) {
					dp[i][j] =0;
				}else {
					dp[i][j] = dp[i][j-1];// ignore the last coin
					
					if(coins[j-1] <= i) {
						dp[i][j]  = dp[i][j]+dp[i-coins[j-1]][j];
					}
				}
				
				
			}
		}
		
		return dp[sum][n];
	}
	
	public static int  getCount(int [] coins, int sum,int n) {
		
		
		if(sum ==0) {
			return 1;
		}
		if(n==0) {
			return 0;
		}
		int res  = getCount(coins, sum, n-1);
		if(coins[n-1] <= sum ) {
			
			  res = res + getCount(coins, sum-coins[n-1], n);
		}
		return res;
	}
	
	public static int findCombination(int[] nums, int target) {

		//Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();

		List<Integer> temp = new ArrayList<>();

		findCombinations(nums, res, temp, target, 0);

//		for (List<Integer> ans : res) {
//			System.out.println(ans.toString());
//		}
		int min_count=Integer.MAX_VALUE;
		
		for(List<Integer> list :res) {
			min_count = Math.min(list.size(), min_count);
		}
		
		return min_count;

	}

	private static void findCombinations(int[] nums, List<List<Integer>> res, List<Integer> temp, int target, int start) {

		if(target ==0) {
			
			res.add(new ArrayList<>(temp));
			return;
		}else if(target < 0) {
			return;
		}

//		if (isTarget(temp)==target) {
//			res.add(new ArrayList<>(temp));
//			return ;
//		}
	

		for (int i = start; i < nums.length; i++) {
			temp.add(nums[i]);
			findCombinations(nums, res, temp, target-nums[i], i);
			temp.remove(temp.size() - 1);
		}

	}

	


}
