package com.leetcode;

/*
You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

 

Example 1:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
Example 2:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
Output: -1
Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
 */
public class MinimumNumberOfDaysToMakeMBouquets_1482 {

	public static void main(String[] args) {
		
	int bloomDay[]=	{1,10,3,10,2};
				int m =3;
				int k=1;
				
				System.out.println(minDays(bloomDay, m, k));
				

	}
	
	 public static int minDays(int[] bloomDay, int m, int k) {
	        
	      if(m*k > bloomDay.length) return -1;
	      int left = 1;
	      int right = 1;
	      
	      for(int i =0;i< bloomDay.length;i++){
	        left = Math.min(left,bloomDay[i]);
	        right = Math.max(right,bloomDay[i]);
	      }
	      
	      while(left < right){
	        int mid =(right + left)/2;
	        if(isPossible(mid,bloomDay,m,k)){
	          right = mid;
	        }else{
	          left = mid+1;
	        }
	      }
	      
	      
	      return left;
	    }
	  
	  public static boolean isPossible(int daysToWait, int [] bloomDay, int b,int f){
	    
	    int count = 0;
	    for(int i=0;i<bloomDay.length;i++){
	      
	      if(bloomDay[i]  <= daysToWait){
	          count++;
	        if(count == f){
	          b--;
	          if(b==0) return true;
	           count=0;
	        }
	       
	      }else{
	        count=0;
	      }
	    }
	    
	    return false;
	  }

}
