package com.leetcode;

/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 */


/*
 * 1. Minimum deletion to make array sorted 
 * 	:- find the LIS of the array  
 * eg [5,10,3,6,7,8] o/p = 2 (delete 5 and 10) as LIS is 4 
 * 
 * nums.length - LIS = 6 - 4 =2 
 * 
*/

/*
 *  * 2. Maximum sum of increasing subsequence(MIS)
 * [3,20,4,6,7,30] = (3+20+30)= 53
 * 
 * int MIS[n]
 * 
 for(int i=0;i<n;i++){
   MIS[i] = nums[i];
   for(int j=0;j<i;j++){
     if(nums[j] < nums[i]){
      MIS[i] = Math.max(MIS[i] , MIS[j]+nums[i])
     }
   }
  }
 * 
 * 
 * 
 * 
 */


/*
 * 3. Max length of bitonic subsequence(count of consecutive up and consecutive down)
 * [1,11,2,10,4,5,2,1] up = 1,2,10 , down = 5,2,1 O/p = up+down = 6
 
  solution : -
  
  1. normal LIS[]
  2. lds (same as LIS from end) 
  
  res = max(lis[i] +lds[i] -1) // -1 bcz we need to consider element only once 
 */
public class LongestIncreasingSubsequence_300 {

	public static void main(String[] args) {
		int []nums = {0,1,0,3,2,3};
		System.out.println(lengthOfLIS(nums));

	}
	
	
	/*
	 * O(n^2)
	 */
	public static  int lengthOfLIS(int[] nums) {
		
		int lis[] = new int[nums.length];
		lis[0] =1;
		for(int i=1;i<nums.length;i++) {
			lis[i]=1;
			for(int j=0;j<i;j++) {
				if(nums[j] < nums[i]) {
					lis[i] = Math.max(lis[i], lis[j]+1);
				}
			}
		}
		
		int max=0;
		for(int i=0;i<nums.length;i++) {
			max = Math.max(max, lis[i]);
		}
		return max;
	}
	
	public static int lis(int []nums) {
		 int [] tail = new int[nums.length];
	      tail[0] = nums[0]; int len =1;
	      for(int i=1;i<nums.length;i++){
	        
	        if(nums[i] > tail[len-1]){
	          tail[len] = nums[i];
	          len++;
	        }else{
	          // search the ceiling position from the Binary Search
	          int c = binarySearch(tail,0,len-1,nums[i]);
	          tail[c] = nums[i];
	        }
	        
	      }
	      return len;
	}
	
	 private static  int binarySearch(int [] tail,int l,int r,int x){
		    while(r>l){
		      int mid = (r+l)/2;
		      
		      if(tail[mid] >=x){
		        r=mid;
		      }else{
		        l = mid+1;
		      }
		    }
		    
		    return r;
		  }

}
