package com.leetcode;

public class Palindrome_number_9 {
	public static void main(String[] args) {
		System.out.println(isPalindrome(1221));
	}
	
	
	public static boolean isPalindrome(int x) {
        if(x==0) return true;
        
        if(x<0 ||x%10 ==0) return false;
        
        int half_reversed=0;
        while(x>half_reversed) {
        	half_reversed = half_reversed *10 + x%10;
        	x=x/10;
        }
        
        if(half_reversed == x || x==half_reversed/10)
        	return true;
        else
        	return false;
    }
	
}
