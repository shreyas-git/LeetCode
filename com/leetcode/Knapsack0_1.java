package com.leetcode;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Arrays;

public class Knapsack0_1 {

	public static void main(String[] args) {

		int val[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };
		int W = 50;

		Instant start = Instant.now();
		System.out.println(knapRecursive(val, wt, W, wt.length));

		// your code

		int[][] memo = new int[wt.length + 1][W + 1];
		for (int[] arr : memo) {
			Arrays.fill(arr, -1);
		}
		System.out.println(knapRecursive_memo(val, wt, W, wt.length, memo));
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");

		System.out.println("DP =" + knap_dp(val, wt, W));
		
		int []arr = {1,2,3,4,5}; int sum = 6;
		System.out.println("subset_sum="+subset_sum(arr, sum));
		
		
		int [] esp = {2,5,5,5,6,3};
		System.out.println("equalSumPartitioning="+equalSumPartitioning(esp));
		
		
		int nums1[] = {2,3,5,6,8,10}; int target = 10;
		System.out.println("count of sum with given sum ="+countOfSubSetSum(nums1,target));

		int nums2[] = {1,2,7};
		System.out.println("minimum_subset_sum_diff="+minimum_subset_sum_diff(nums2, 10));
	
		int nums3[]= {1,1,2,3}; int diff= 1;
		System.out.println("count of subset with given diff= "+ count_of_subset_with_given_diff(nums3,diff));
		
		int nums4[]= {1,1,2,3}; int target_sum = 1;
		System.out.println("target Sum 494-leetcode="+target_sum(nums4,target_sum));
		
		// unbounded kanpsack
		
		int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
		int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
		int rod_length= 4;
		
		System.out.println("Maximum profit after cutting rods to make given length"+ rod_cutting_problem(length,price,rod_length));
		
		
		int coins []= {1,2,3}; int amount= 5;
		/*
		 * 1+1+1+1+1 = 5
		 * 1+1+1+2 = 5
		 * 1+1+3 = 5
		 * 2+3 = 5
		 * 2+2+1 = 5
		 * o/p = total 5 ways 
		 */
		System.out.println("max_number_coins_ways_to_make_sum= "+max_number_coins_ways_to_make_sum(coins,amount));
		
		
		System.out.println("Minimum Number of ways to make sum ="+min_number_of_coins_required_to_make_sum(coins,amount));
	}

	private static int min_number_of_coins_required_to_make_sum(int[] coins, int amount) {
		int n = coins.length;
		int dp[][] = new int[n+1][amount+1];
		
		for(int arr[]:dp) {
			Arrays.fill(arr, Integer.MAX_VALUE-1);
		}
		
		// below two initialization steps is diff than the knapsack
		//for(int j=0;j<=amount;j++) dp[0][j]=0;
		for(int i=1;i<=n;i++) dp[i][0] = 0;  
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=amount;j++) {
				if(coins[i-1]<=j) {
					dp[i][j]= Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
				}else {
					dp[i][j]= dp[i-1][j];
				}
			}
		}
		
		
		
		return dp[n][amount];
	}

	private static int max_number_coins_ways_to_make_sum(int[] coins, int amount) {
		int n = coins.length;
		int dp[][] = new int[n+1][amount+1];
		
		// below two initialization steps is diff than the knapsack
		for(int j=0;j<=amount;j++) dp[0][j]=0;
		for(int i=1;i<=n;i++) dp[i][0] = 1;  
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=amount;j++) {
				if(coins[i-1]<=j) {
					dp[i][j]= dp[i-1][j]+ dp[i][j-coins[i-1]];
				}else {
					dp[i][j]= dp[i-1][j];
				}
			}
		}
		
		
		
		return dp[n][amount];
	}

	/*
	 * if length arr is not given then create length array or
	 * do below changes 
     if(length[i-1] <= j) {
					dp[i][j] = Math.max(dp[i-1][j],
							            price[i-1]+dp[i][j-i]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
	 */
	private static int rod_cutting_problem(int[] length, int[] price, int rod_length) {
		int n = price.length;
		int dp[][] = new int [n+1][rod_length+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=rod_length;j++) {
				
				if(length[i-1] <= j) {
					dp[i][j] = Math.max(dp[i-1][j],
							            price[i-1]+dp[i][j-length[i-1]]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
			
			
		}
		
		return dp[n][rod_length];
	}

	private static int target_sum(int[] nums, int target_sum) {
		int sum = 0;
		for(int num:nums) sum +=num;
		
		int target  = (target_sum+sum)/2;
		
		int n = nums.length;
		int dp[][] = new int [n+1][target+1];
		
		for(int i=0;i<=n;i++) dp[i][0]=1;
		for(int j=1;j<=target;j++) dp[0][j]=0;
		  
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=target;j++) {
				if(nums[i-1]>j) {
					dp[i][j]= dp[i-1][j];
				}else {
					dp[i][j]= dp[i-1][j]+dp[i-1][j-nums[i-1]];
				}
			}
		}
		
		return dp[n][target];
	}

	private static int count_of_subset_with_given_diff(int[] nums, int diff) {
		
		/*
		 * s1+s2 = sum(arr) 
		 * s1-s2 = diff
		 * 
		 * add above two 
		 * 
		 * 2s1 = diff+sum(arr)
		 * s1 = (diff+sum(arr))/2
		 * so we have to find target with s1
		 */
		int sum = 0;
		for(int num:nums) sum +=num;
		
		int target  = (diff+sum)/2;
		
		int n = nums.length;
		int dp[][] = new int [n+1][target+1];
		
		for(int i=0;i<=n;i++) dp[i][0]=1;
		for(int j=1;j<=target;j++) dp[0][j]=0;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=target;j++) {
				if(nums[i-1]>j) {
					dp[i][j]= dp[i-1][j];
				}else {
					dp[i][j]= dp[i-1][j]+dp[i-1][j-nums[i-1]];
				}
			}
		}
		
		return dp[n][target];
	}

	private static int countOfSubSetSum(int[] nums, int target) {
		
		int n = nums.length;
		int [][] dp = new int [n+1][target+1];
		
		for(int sum=0;sum<n+1;sum++) dp[sum][0] = 1;
		for(int ele=1;ele<target+1;ele++) dp[0][ele]=0;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=target;j++) {
				
				if( nums[i-1] >j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j]+ dp[i-1][j-nums[i-1]];
				}
				}
			}
		
		
		return dp[n][target];
	}

	private static boolean equalSumPartitioning(int[] nums) {
		
		int sum =0;
		int n = nums.length;
		for(int i=0;i<n;i++) {
			sum +=nums[i];
		}
		
		if(sum %2 !=0) return false;
		
		boolean [][]dp = new boolean [n+1][sum/2+1];
		
		for(int num=0;num<=n;num++) dp[num][0] = true;
		for(int s=1;s<=sum/2;s++) dp[0][s] = false;
		
		
		for(int i=1;i<=n;i++) {         // i -> nums
			for(int j=1;j<=sum/2;j++) { // j -> sum
				
				if(nums[i-1]<=j) {
					dp[i][j] = dp[i-1][j]  ||/*do not choose */  
							   dp[i-1][j-nums[i-1]]; // choose
				}
			}
		}

		return dp[n][sum/2];
	}

	public static int knapRecursive(int val[], int wt[], int w, int n) {

		if (n == 0 || w == 0)
			return 0;

		if (wt[n - 1] > w) {
			return knapRecursive(val, wt, w, n - 1);// do not consider
		} else {
			return Math.max(knapRecursive(val, wt, w, n - 1), // do not choose find better
					val[n - 1] + knapRecursive(val, wt, w - wt[n - 1], n - 1)); // what if we choose
		}

	}

	public static int knapRecursive_memo(int val[], int wt[], int w, int n, int[][] memo) {

		if (n == 0 || w == 0)
			return 0;

		if (memo[n - 1][w - 1] != -1)
			return memo[n - 1][w - 1];
		if (wt[n - 1] > w) {
			return memo[n - 1][w - 1] = knapRecursive(val, wt, w, n - 1);// do not consider
		} else {
			return memo[n - 1][w - 1] = Math.max(knapRecursive(val, wt, w, n - 1), // do not choose find better
					val[n - 1] + knapRecursive(val, wt, w - wt[n - 1], n - 1)); // what if we choose
		}

	}

	public static int knap_dp(int val[], int wt[], int w) {
		int dp[][] = new int[wt.length + 1][w + 1];
		int n = wt.length;

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= w; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;

				else if (wt[i - 1] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
				}
			}
		}

		return dp[n][w];
	}

	public static boolean subset_sum(int []arr,int sum) {
		int n = arr.length;
		boolean [][] dp = new boolean [n+1][sum+1];
		
		for(int i=0;i<n+1;i++) dp[i][0] = true;
		for(int i=1;i<sum+1;i++) dp[0][i] = false;
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				
				
				 if(arr[i-1] <=j) {
					dp[i][j] =dp[i-1][j] || dp[i-1][j-arr[i-1]];
				}
			}
		}
		
		
		
		
		return dp[n][sum];
	}
	
	
	
	public static int minimum_subset_sum_diff(int []arr,int sum) {
		int n = arr.length;
		boolean [][] dp = new boolean [n+1][sum+1];
		
		for(int i=0;i<n+1;i++) dp[i][0] = true;
		for(int i=1;i<sum+1;i++) dp[0][i] = false;
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				
				
				 if(arr[i-1] >j) {
					 dp[i][j] =dp[i-1][j];
				}else {
					dp[i][j] =dp[i-1][j] || dp[i-1][j-arr[i-1]];
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		
		for(int i=1;i<=sum;i++) {
			
			if(dp[n][i]) {
				min = Math.min( Math.abs(sum - 2*i),min);
			}
		}
		
		
		
		return min;
	}
	
	
}
