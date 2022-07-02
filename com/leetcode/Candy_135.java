package com.leetcode;

/*
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 */
public class Candy_135 {

	public static void main(String[] args) {
		int ratings [] = {1,3,4,5,2};
		System.out.println(candy(ratings));

	}
	
	
	/*
	 * this problem is similar to Trapping rain water 
	 * finding left max and right max
	 */
	public static  int candy(int[] ratings) {
	      
	      if(ratings.length ==0 ){
	        return 0;
	      }
	      
	      // take an array for distribution of candy
	      int [] candy = new int [ratings.length];
	      //each can get min 1 candy 
	      candy[0] =1;
	      
	      // move from left -> right
	      for(int i=1;i<ratings.length;i++ ) {
	    	  if(ratings[i]>ratings[i-1]) {
	    		  candy[i] = candy[i-1]+1;
	    		}else {
	    			candy[i] =1;
	    		}
	      }
	      
	      for(int i=0;i<ratings.length;i++) {
	    	  System.out.println(i+ "-> " + candy[i]);
	    	 
	      }
	      
	      
	      // move from right -> left 
	      for(int i = ratings.length-2;i>=0;i--) {
	    	  if(ratings[i]>ratings[i+1]) {
	    		 //candy[i] = candy[i+1]+1; 
	              // here is the twist 
	              candy[i] = Math.max(candy[i],candy[i+1]+1);
	    	  }
	      }
	      
	      int res =0;
	      for(int i=0;i<ratings.length;i++) {
	    	  System.out.println(i+ "-> " + candy[i]);
	    	  res +=candy[i];
	      }
	      
	      return res;
	    }

}



