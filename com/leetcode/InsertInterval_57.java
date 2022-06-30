package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
 */
public class InsertInterval_57 {

	public static void main(String[] args) {
		int [][] intervals = {{1,3},{6,9}}; 
		int [] newInterval = {2,5};
		
		
		int [][] res= insert(intervals, newInterval);
		for(int [] r :res) {
			System.out.print("[");
			for(int a:r) {
				System.out.print(a+",");
			}
			System.out.print("]");
			System.out.println();
		}

	}

	 public static int[][] insert(int[][] intervals, int[] newInterval) {
	        
	        List<int[]> input_intervals = new ArrayList<>();
	        
	        for(int [] interval:intervals){
	            input_intervals.add(interval);
	        }
	        input_intervals.add(newInterval);
	        
	         intervals = input_intervals.toArray(new int[input_intervals.size()][]);
	        
	         
	         
	         
	         return merge(intervals);
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
