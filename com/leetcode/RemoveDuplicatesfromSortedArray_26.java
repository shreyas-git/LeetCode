package com.leetcode;

/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length. Do not allocate extra space for another array, you must do this in place with constant memory.

For example, given input array A = [1,1,2], your function should return length = 2, and A is now [1,2].
 */

/*
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class RemoveDuplicatesfromSortedArray_26 {

	public static void main(String[] args) {
		
		int nums []= {0,0,1,1,1,2,2,3,3,4};
		
		System.out.println(removeDuplicates(nums));
	}
	
	 public static  int removeDuplicates(int[] nums) {
         int insert_index= 1;
        
        for(int i =1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[insert_index]= nums[i];
                insert_index++;
            }
        }
        return insert_index;
    }

}
