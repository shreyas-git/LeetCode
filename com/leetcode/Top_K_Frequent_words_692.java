package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Top_K_Frequent_words_692 {

	public static void main(String[] args) {
		String []words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
		int k = 4;
		System.out.println(topKFrequent(words, k));

	}
	
	 public static List<String> topKFrequent(String[] words, int k) {
	        Map<String,Integer> map = new LinkedHashMap();
	       List<String> res = new ArrayList<>();
	      for(String word:words){
	        if(map.containsKey(word)){
	          map.put(word,map.get(word)+1);
	        }  
	        else{
	          map.put(word,1);
	        }
	      }
	    map  = sortByValue(map);
	       for (Map.Entry<String,Integer> entry : map.entrySet()){
	         if(k>0){
	           
	           res.add(entry.getKey());
	           k--;
	         }else{
	           break;
	         }
	       }
	           
	          
	         return res;
	      }
	      
	  
	   public static HashMap<String, Integer> sortByValue(Map<String, Integer> hm)
	    {
	        // Create a list from elements of HashMap
	        List<Map.Entry<String, Integer> > list =
	               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
	 
	        // Sort the list
	        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
	            public int compare(Map.Entry<String, Integer> o1,
	                               Map.Entry<String, Integer> o2)
	            {
	                return (o2.getValue()).compareTo(o1.getValue());
	            }
	        });
	         
	        // put data from sorted list to hashmap
	        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
	        for (Map.Entry<String, Integer> aa : list) {
	            temp.put(aa.getKey(), aa.getValue());
	        }
	        return temp;
	    }

}
