package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DecodeWays_91 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "226";
		
		System.out.println(decode(s,0,new int[s.length()]));

	}
	
	public int numDecodings(String s) {
        return decode(s,0,new int[s.length()]);
    }
  
    public  static int decode(String s, int start, int [] cache){
      if(s.length() == start){
        return 1;
      }
      // special case 
      if(s.charAt(start) == '0'){
        return 0;
      }
      
      if(cache[start] != 0) return cache[start];
      int res = decode(s,start+1,cache); // check for individual character
      
      if(start < s.length() -1){
        if(s.charAt(start) == '1' || s.charAt(start)=='2' && s.charAt(start+1) < '7'){ //s.charAt(start+1) < '7' bcz only 26 characters are allowed
          res = res + decode(s,start+2, cache);// check for 2 char with range 10 to 26 , Then sum up the res.
          
        }
      }
      cache[start] = res;
      return res;
      
      
    }

    /*
     * below solution won't give proper solution
     */
	private static void decode_Backtracking(String s) {
		Set<Integer> set = new HashSet<>();
		for(int i=1;i<=26;i++) {
			set.add(i);
		}
		List<String> res  = new ArrayList<>();
		int count=0;
		
		helper(s,new StringBuilder(),res,0);
		
		System.out.println(res);
		for(String str:res) {
			if(set.contains(Integer.valueOf(str))) {
				count++;
				set.remove(Integer.valueOf(str));
			}
		}
		
		System.out.println("count = "+ count);
		
	}

	private static void helper(String s, StringBuilder sb, List<String> res, int index) {
		if(sb.length() >1 ) {
			res.add(sb.toString());
			
		}else if(sb.length() ==2 ) {
			res.add(sb.toString());
			//return;
		}
		
		for(int i=index;i<s.length();i++) {
			sb.append(s.charAt(i));
			helper(s, sb, res, index+1);
			sb.deleteCharAt(sb.length()-1);
		}
		
	}
	

	

}
