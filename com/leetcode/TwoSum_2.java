package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_2 {

	public static void main(String[] args) {
		
		int []nums = {2,7,11,15};
		int target = 9;
		System.out.println(twoSum(nums, target));

	}
	
	public static  int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        
        int []res = new int[2];
        for(int i=0;i<nums.length;i++){
            
            if(map.containsKey(nums[i])){
                int first = map.get(nums[i]);
                res[0] = first;
                res[1] =i;
                break;
            }else{
                map.put(target-nums[i],i);
            }
        }
        
        return res;
    }

}
