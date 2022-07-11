package com.leetcode;

/*
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer;
 in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 */
public class PerfectSquares_279 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println(numSquares(12));
		
		String s = "dig1 8 1 5 1";
		  String[] split1 = s.split(" ", 2);
		  for(String a: split1) {
			  System.out.println(a);
		  }
	}

	
	public static int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i = 1; i <=n; i++)
            dp[i] = i;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }
        return dp[n];
 }
}
