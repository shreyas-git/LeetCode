package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: true
 */
public class MeetingRooms_252 {

	public static void main(String[] args) {
		
		int [][] intervals = {{0,30},{5,10},{15,20}};
		System.out.println(canAttendMeetings(intervals));

	}
	
	public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
     
     ArrayList<int[]> res = new ArrayList<>();
     int [] cur_interval = intervals[0];
     res.add(cur_interval);
     
     for(int [] interval:intervals){
       int cur_start = cur_interval[0];
       int cur_end = cur_interval[1];
       int next_start = interval[0];
       int next_end = interval[1];
       
       if(cur_end >= next_start){
        cur_interval[1]= Math.max(next_end, cur_end) ;
       }else{
         res.add(interval);
				  cur_interval= interval;
       }
     }
     
     System.out.println(res.size());
     return res.size() == intervals.length;
   }

}
