package com.leetcode;
/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 */
public class SearchinRotatedSortedArray_33 {

	public static void main(String[] args) {
		int nums[] = {5,1,2,3,4};
		System.out.println(searchNew(nums, 1));

	}
	
	 public static int search(int[] nums, int target) {
	        
		 
	        int l=0;
	        int r=nums.length -1;
	        
	        if(r==1){
	            for(int i=0;i<=r;i++){
	                if(nums[i]==target){
	                    return i;
	                }
	            }
	            return -1;
	        }
	        
	        while(l<=r){
	            int m = (l+r)/2;
	            
	            if(nums[m] == target){
	                return m;
	            }
	            if(nums[l]<=nums[m]){
	                // left half is sorted
	                if(target >=nums[l]  && target < nums[m]){
	                    r = m -1;
	                }else{
	                    l = m+1;
	                }
	                
	            }else{
	                // right half is sorted
	                if(target > nums[m] && target <= nums[r]){
	                    l = m+1;
	                }else{
	                    r= m-1;
	                }
	            }
	            
	        }
	        
	        return -1;
	    }
	 
	 static int searchNew(int arr[], int x)
		{
		 int n = arr.length;
			int low = 0, high = n - 1;

			while(low <= high)
			{
				int mid = (low + high) / 2;

				if(arr[mid] == x)
					return mid;
				if(arr[low] < arr[mid])
				{
					if(x >= arr[low] && x < arr[mid])
						high = mid - 1;
					else 
						low = mid + 1;
				}
				else
				{
					if(x > arr[mid] && x <= arr[high])
						low = mid + 1;
					else
						high = mid - 1;
				}
			}
			

			return -1;
		}

}
