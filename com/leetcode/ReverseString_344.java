package com.leetcode;

public class ReverseString_344 {

	/*
	 * Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
	 */
	
	/*
	 * Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.
	 */
	public static void main(String[] args) {
		
		char [] s = {'h','e','l','l','o'};
		reverseString(s);
		for(char c : s) {
			System.out.print(c +",");
		}
	}
	
public static void reverseString(char[] s) {
        int l =0;
        int r= s.length-1;
        
        while(l<=r) {
        	char temp = s[r];
        	s[r]= s[l];
        	s[l]=temp;
        	l++;
        	r--;
        }
    }

}
