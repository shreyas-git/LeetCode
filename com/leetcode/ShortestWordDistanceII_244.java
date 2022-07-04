package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Design a data structure that will be initialized with a string array, and then it should answer queries of the shortest distance between two different strings from the array.

Implement the WordDistance class:

WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
int shortest(String word1, String word2) returns the shortest distance between word1 and word2 in the array wordsDict.
 

Example 1:

Input
["WordDistance", "shortest", "shortest"]
[[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]
Output
[null, 3, 1]

Explanation
WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
wordDistance.shortest("coding", "practice"); // return 3
wordDistance.shortest("makes", "coding");    // return 1
 */
public class ShortestWordDistanceII_244 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] dic = {"practice", "makes", "perfect", "coding", "makes"};
		WordDistance wordDistance = new WordDistance(dic);
		System.out.println(wordDistance.shortest("coding", "practice")); // return 3
		System.out.println(wordDistance.shortest("makes", "coding"));    // return 1
	}
	
	

}

class   WordDistance {

	  Map<String ,ArrayList<Integer>> map = new HashMap<>();
	    public WordDistance(String[] wordsDict) {
	        for(int i=0;i<wordsDict.length;i++){
	          if(map.containsKey(wordsDict[i])){
	            map.get(wordsDict[i]).add(i);
	          }else{
	            ArrayList<Integer> list = new ArrayList<>();
	            list.add(i);
	            map.put(wordsDict[i],list);
	          }
	          
	        }
	    }
	  

		public int shortest(String word1, String word2) {
	      List<Integer> loc1 = map.get(word1);
	      List<Integer> loc2 = map.get(word2);
	      
	      int l1 =0;
	      int l2 =0;
	      int min_diff = Integer.MAX_VALUE;
	      
	      while(l1<loc1.size() && l2<loc2.size()){
	        
	        int abs_value = Math.abs(loc1.get(l1) -loc2.get(l2));
	        min_diff = Math.min(abs_value,min_diff);
	        if(loc1.get(l1) > loc2.get(l2)){
	          l2++;
	        }else{
	          l1++;
	        }
	      }
	      return min_diff;  
	    }
	}
