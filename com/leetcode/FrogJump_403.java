package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/*
A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.

If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.

 

Example 1:

Input: stones = [0,1,3,5,6,8,12,17]
Output: true
Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
Example 2:

Input: stones = [0,1,2,3,4,8,9,11]
Output: false
Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.
 */
public class FrogJump_403 {

	public static void main(String[] args) {
		
		int []stones = {0,1,3,5,6,8,12,17};
		System.out.println(canCross(stones));

	}
	
/*[0,1,3,5,6,8,12,17]
 
 stones will be in position 
 
 0,1,_,3,_,5,6,_,8,_,_,_,12,_,_,_,_,17 
 
 possible jumps = jump-1,jump,jump+1
 
 0 -> 1
 1 -> 1,2 (if 1 jump then jump into water (water) _ , curJump = 1 , (curJump+1) = (1+1) is not there in array
(1+2) == 3 , 3 is there in the array

 3 ->  1,2  (3+2) = 5
 
 //5 -> (took 2 jumps ) so values will be   possible jumps = jump-1,jump,jump+1
 5 ->     1,2,3
 6 ->     1,2
 8 ->     1,2,3(from 5),4
 12 ->        3,4,5
 (12+3) = 15 not in array , (12+4)= 16 not possible ,(12+5) = 17 hence reached the end
 17 -> 
 
  
 */
	
	 public static boolean canCross(int[] stones) {
	        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
	      
	      for(int i=0;i<stones.length;i++){
	        map.put(stones[i],new HashSet<Integer>());
	      }
	      
	      map.get(stones[0]).add(1); // 0 -> 1
	      //0,1,2,3,4,8,9,11
	      for(int i=0;i< stones.length;i++){
	        int curStone = stones[i];  // 0
	        
	        HashSet<Integer> jumps = map.get(curStone); //[1]
	        
	        for(int jump:jumps){
	          int nextJump = curStone+jump; // 0 + 1
	          
	          if(nextJump == stones[stones.length -1]) return true;
	          
	          if(map.containsKey(nextJump)){
	            if(jump -1 > 0){
	                map.get(nextJump).add(jump -1); // K-1
	            }
	           
	            map.get(nextJump).add(jump );   // K
	            map.get(nextJump).add(jump +1); // K+1
	          }
	        }
	      }
	      
	      return false;
	    }

}
