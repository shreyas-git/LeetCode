package com.leetcode;

public class HouseRobber_213 {

	public static void main(String[] args) {
		int nums []= {1,2,3,1};
		System.out.println(rob(nums));

	}

	public static int rob(int[] nums) {
	      // if(nums.length == 1) return nums[0];
	        if(nums.length == 2) return Math.max(nums[0], nums[1]);
	        return Math.max(rob(nums,1, nums.length-2)
	        		,rob(nums,2, nums.length-1) );
	    }
	  
	  public static int rob(int[] nums, int start, int end) {
	  
	     int dp[] = new int[nums.length+1];
		      dp[0] =0;
		      dp[start] = nums[start-1];
		      
		      //[2,7,9,3,1]
		 // dp[0,2,7,11,10,12]
		      for(int i=start;i<=end;i++){
		        dp[i+1]= Math.max(dp[i-1]+nums[i],dp[i]);
		      }
		      
		      return dp[end+1];
	    
	  }
}
