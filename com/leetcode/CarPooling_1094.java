package com.leetcode;

import java.util.Arrays;

/*
There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

 

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
 */
public class CarPooling_1094 {

	public static void main(String[] args) {
		int [][] trips ={{2,1,5},{3,3,7}};
		int capacity = 5;
		System.out.println(carPooling(trips, capacity));

	}

	
	public static boolean carPooling(int[][] trips, int capacity) {

	    int [] max_location = new int[1001];
	      
	      int max_trip_end = 0;
	      
	      for(int [] trip :trips){
	        int start = trip[1];
	        int end = trip[2];
	        max_trip_end = Math.max(max_trip_end,end);
	        
	        max_location[start] = max_location[start]+trip[0];
	        max_location[end] = max_location[end] - trip[0];
	        
	      }
	      
	      
	      for(int i=1;i<=max_trip_end;i++){
	        max_location[i] = max_location[i]+max_location[i-1];
	      }
	      
	      for(int i=0;i<max_trip_end;i++){
	        if(max_location[i] >capacity ) return false;
	      }
	      return true;
	}
}
