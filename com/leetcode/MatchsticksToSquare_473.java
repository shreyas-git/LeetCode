package com.leetcode;

import java.util.Arrays;

public class MatchsticksToSquare_473 {

	public static void main(String[] args) {
		
		int matchsticks []= {1,1,2,2,2};
		System.out.println(makesquare(matchsticks));

	}
	
	public static  boolean makesquare(int[] matchsticks) {
        // soution  :-  Backtracking
      
        // divide the array in to 4 equal parts if it is possible then we can make the square 
        // otherwise we cann't make 
        // sum / 4 = target
        // SUM % 4 == 0 OTHETRWISE not possible
      int n= matchsticks.length;
      int sum=0;
      for(int i=0;i<n;i++) sum +=matchsticks[i];
      
      if(sum%4 != 0) return false;
      
      // try all possible combination to form 4 equal partition
      Arrays.sort(matchsticks);
     return  helper(matchsticks,0,sum/4,1,0,new boolean[matchsticks.length]);
    }
  
  public static boolean helper(int [] nums,int temp,int target,int groupId,int index,boolean[] visited){
    
    if(groupId == 4) return true;
    if(temp > target) return false;
    
    if(target == temp) return helper(nums,0,target,groupId+1,0,visited);
    
    for(int i = index;i<nums.length;i++){
      
      if(visited[i]) continue;
      
      if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
      visited[i] = true;
      if(helper(nums,temp+nums[i],target,groupId,i+1,visited)){
        return true;
      }
      visited[i] = false;
    }
    
    return false;
  }

}
