package com.leetcode;

public class PartitionEqualSubsetSum_416 {

	public static void main(String[] args) {
		
		int []nums = {4,4,4,4,4,4,4,4,8,8,8,8,8,8,8,8,12,12,12,12,12,12,12,12,16,16,16,16,16,16,16,16,20,20,20,20,20,20,20,20,24,24,24,24,24,24,24,24,28,28,28,28,28,28,28,28,32,32,32,32,32,32,32,32,36,36,36,36,36,36,36,36,40,40,40,40,40,40,40,40,44,44,44,44,44,44,44,44,48,48,48,48,48,48,48,48,52,52,52,52,52,52,52,52,56,56,56,56,56,56,56,56,60,60,60,60,60,60,60,60,64,64,64,64,64,64,64,64,68,68,68,68,68,68,68,68,72,72,72,72,72,72,72,72,76,76,76,
76,76,76,76,76,80,80,80,80,80,80,80,80,84,84,84,84,84,84,84,84,88,88,88,88,88,88,88,88,92,92,92,92,92,92,92,92,96,96,96,96,96,96,96,96,97,99};

		System.out.println(canPartition(nums));
	}
	
	 public static  boolean canPartition(int[] nums) {
	        
	      int sum =0;
	      
	      for(int i=0;i<nums.length;i++) sum +=nums[i];
	      
	      if(sum%2 != 0 )  return false;
	      
	      return helper(nums,0,sum/2);
	    }
	  
	  public static boolean helper(int [] nums, int index , int target){
	    
	    if(target==0) return true;
	    if(index == nums.length || target < 0) return false;
	   if(helper(nums,index+1,target-nums[index])) return true;
	    
	     int j = index + 1;
	        while (j < nums.length && nums[index] == nums[j]) {
	            j++;
	        }

	        return helper(nums, j, target);
	    

	  }

}
