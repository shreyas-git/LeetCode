package com.leetcode;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

 

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
 */
public class LengthOfLastWord_58 {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World    "));

	}
	
	
public static int lengthOfLastWord(String s) {
        
        
        s = s.trim();
        
        String [] str = s.split("\\s");
        int n = str.length-1;
        return str[n].length();
    }

public int minimumTotal(List<List<Integer>> triangle) {
	int sum = 0;
    for(int i =0;i< triangle.size();i++){
        Set<Integer> set = new TreeSet<>();
        
        for(Integer row: triangle.get(i)){
            set.add(row);
        }
        sum =sum+set.iterator().next();
        // row ends 
        
        
    }
    
    return sum;
}

}
