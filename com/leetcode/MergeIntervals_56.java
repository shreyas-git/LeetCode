package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_56 {

	public static void main(String[] args) {
		int [][] intervals = {{1,2},{3,6},{8,10},{9,18}};
				//Output: {{1,6},{8,10},{15,18}}
		
		int [][] res= merge(intervals);
		for(int [] r :res) {
			System.out.print("[");
			for(int a:r) {
				System.out.print(a+",");
			}
			System.out.print("]");
			System.out.println();
		}

	}
	
	 public static  int[][] merge(int[][] intervals) {
		 
		if(intervals.length <=1) {
			return intervals;
		}
		 
		//sort based on the start time
		Arrays.sort(intervals, (arr1,arr2) -> Integer.compare(arr1[0], arr2[0]));
		 
		List<int []> res = new ArrayList();
		
		int [] cur_interval = intervals[0];//{1,3}
		 //{{1,3},{2,6},{8,10},{15,18}}
		res.add(cur_interval);
		for(int [] interval:intervals) {
			int cur_begin = cur_interval[0];
			int cur_end = cur_interval[1];
			int next_begin = interval[0];
			int next_end = interval[1];
			
			if(cur_end >= next_begin) {
				cur_interval[1]= Math.max(next_end, cur_end) ;
			}else {
				
				res.add(interval);
				cur_interval= interval;
			}
		}
		 
		 return res.toArray(new int[res.size()][]);
	        
	    }

}
