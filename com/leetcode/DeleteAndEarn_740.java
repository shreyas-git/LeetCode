package com.leetcode;

public class DeleteAndEarn_740 {

	public static void main(String[] args) {
		
		int [] nums = {3,4,2};
		System.out.println(deleteAndEarn(nums));

	}
	
	public static int deleteAndEarn(int[] nums) {
        int ex= 0;
        int in =0;
        int arr[] = new int[100001];
        int max = 0;
      for(int i=0;i<nums.length;i++){
        arr[nums[i]]++;
        max = Math.max(max,nums[i]);
      }
      
      for(int i=1;i<=max;i++){
        int temp = in;
        in   = ex + arr[i] *i;
        ex = Math.max(ex,temp);
        
        
        
      }
      
      return Math.max(in,ex);
    }

}
