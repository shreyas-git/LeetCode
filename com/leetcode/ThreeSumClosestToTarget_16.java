package com.leetcode;

import java.util.Arrays;

public class ThreeSumClosestToTarget_16 {

	public static void main(String[] args) {
		
		int []nums = {-1,2,1,-4};
		int target = 1;
		System.out.println(threeSumClosest(nums,target));

	}

public static  int threeSumClosest(int[] nums, int target) {
        
        int dif= Integer.MAX_VALUE;
        Arrays.sort(nums);
        
        for (int i=0;i<nums.length -2 ;i++) {
        	int lo= i+1;
        	int hi = nums.length -1;
        	
        	while(lo<hi) {
        		
        		int sum = nums[i] +nums[lo]+nums[hi];
        		if(Math.abs(target-sum) < Math.abs(dif)) {
        			dif= target-sum;
        		}
        		
        		if(sum > target) {
        			hi--;
        		}else {
        			lo++;
        		}
        	}
        }
        
        
        return target - dif;
        
    }

}
