package com.leetcode;

public class MergeSortedArray_88 {

	public static void main(String[] args) {
		
		int [] nums1 = {1,2,3,0,0,0}; int m = 3;
		int []nums2 =  {2,5,6};       int n = 3;
		
		merge(nums1,m,nums2,n);
		
		for(int i :nums1)
			System.out.print(i+" ");

	}

	private static void merge(int[] nums1, int m, int[] nums2, int n) {
		m--;n--;

		//start filling from end
		for(int i=nums1.length-1; i>=0 ;i--) {
			int val= 0;
			
			if(m >= 0 && n >= 0 ) {
				val = nums1[m]>nums2[n]?nums1[m--]:nums2[n--];
				
			}else if(n<0) {
				val = nums1[m--];
			}else {
				val = nums2[n--];
			}
			
			nums1[i] = val;
		}
		
	}
	
	

}
