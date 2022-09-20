package com.leetcode;

import java.util.Arrays;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "axyt";
		String s2 =  "ayzx";
		
		System.out.println("LCS Recursive="+lcs_recursive(s1,s2,s1.length(),s2.length()));
		
		int [][]memo=new int [s1.length()+1][s2.length()+1];
		for(int []arr:memo) Arrays.fill(arr, -1);
		System.out.println("LCS Recursive="+lcs_recursive_memo(s1,s2,s1.length(),s2.length(),memo));
		
		System.out.println("LCS DP ="+lcs_dp(s1,s2));
		System.out.println("Longest common substring="+longest_common_substring("batrr","cat"));
		System.out.println("Print LCS ="+ print_LCS("abcdef","axycegf"));
		
		System.out.println("length of shortest common super sequence = "+ shortest_common_super_sequence("geek","eke"));
		
		System.out.println("Minimun number of insertion/deletion to make string 1 to string 2 is ="+minimun_insertion_deletion("heap","pea"));
	 
		System.out.println("Length of Longest palindromic subsequnce = "+ longest_palindromic_subsequnce("agbcba"));
		
		System.out.println("Minimun number of deletion to make string to palindrome :"+ minimum_deletion_to_make_palindrome("agbcba"));
		
		System.out.println("Minimun number of insertion to make string to palindrome :"+ minimum_insertion_to_make_palindrome("aebcbda"));
	
		System.out.println("Print Shortest common Supersequnce="+ print_shortest_common_supersequnce("AGGTAB","GXTXAYB"));
		
		System.out.println("Longest repeating subsequnce = "+Longest_repeating_subsequnce("AABEBCDD"));
		
		System.out.println("Sequence Pattern Matching is s1 present in s2 = "+ sequence_pattern_matching("AXY","ADXCPY"));
		


	}

	

	private static boolean sequence_pattern_matching(String s1, String s2) {
		
		int m = s1.length();
		int n = s2.length();
		int dp [][] = new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					dp[i][j]= 0;
				}else {
					if(s1.charAt(i-1) == s2.charAt(j-1)) {
						dp[i][j] = 1+dp[i-1][j-1];
					}else {
						dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
					}
				}
			}
		}
		
		return dp[m][n]==Math.min(m, n)?true:false;
	}

	/*
	 * AABEBCDD
	 * o/p = 3
	 * Longest repeating subsequnce = ABD since it appeared two times and its length is 3 
	 * 
	 */
	private static int Longest_repeating_subsequnce(String s1) {
		String s2 = s1;
		int m = s1.length();
		int n = s2.length();
		int dp [][] = new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					dp[i][j]= 0;
				}else {
					if(s1.charAt(i-1) == s2.charAt(j-1) && i!=j) {
						dp[i][j] = 1+dp[i-1][j-1];
					}else {
						dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
					}
				}
			}
		}
		
		return dp[m][n];
	}

	private static String print_shortest_common_supersequnce(String s1, String s2) {
		
		int m = s1.length();
		int n = s2.length();
		int dp [][] = new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					dp[i][j]= 0;
				}else {
					if(s1.charAt(i-1) == s2.charAt(j-1)) {
						dp[i][j] = 1+dp[i-1][j-1];
					}else {
						dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int i = m,j=n;
		
		
		while(i>0 && j>0) {
			if(s1.charAt(i-1)  == s2.charAt(j-1)){
				sb.insert(0,s1.charAt(i-1));
				i--;
				j--;
			}else {
				if(dp[i][j-1]>dp[i-1][j]) {
					sb.insert(0,s2.charAt(j-1));
					j--;
				}else {
					sb.insert(0,s1.charAt(i-1));
					i--;
				}
				
				
			}
		}
		
		while(i>0) {
			sb.insert(0,s1.charAt(i-1));
			i--;
		}
		
		while(j>0) {
			sb.insert(0,s1.charAt(j-1));
			j--;
		}
		return sb.toString();
	}

	private static int minimum_deletion_to_make_palindrome(String s1) {

		/*
		 * s1 = agbcba
		 * s2 = abcbga 
		 * 
		 * lcs = abcba (5)
		 */
		String s2 = new StringBuilder(s1).reverse().toString();
		int m = s1.length();
		int n = s2.length();
		
		int dp[][] = new int [m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0||j==0) {
					dp[i][j]=0;
				}else {
					if(s1.charAt(i-1)==s2.charAt(j-1)) {
						dp[i][j]=1+dp[i-1][j-1];
					}else {
						dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
					}
					
				}
			}
		}
		
		return m-dp[m][n];
	}
	
	
	private static int minimum_insertion_to_make_palindrome(String s1) {
		/*
		 * s1 = agbcba
		 * s2 = abcbga 
		 * 
		 * lcs = abcba (5)
		 */
		String s2 = new StringBuilder(s1).reverse().toString();
		int m = s1.length();
		int n = s2.length();
		
		int dp[][] = new int [m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0||j==0) {
					dp[i][j]=0;
				}else {
					if(s1.charAt(i-1)==s2.charAt(j-1)) {
						dp[i][j]=1+dp[i-1][j-1];
					}else {
						dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
					}
					
				}
			}
		}
		return m-dp[m][n];
	}

	private static int longest_palindromic_subsequnce(String s1) {
		
		/*
		 * s1 = agbcba
		 * s2 = abcbga 
		 * 
		 * lcs = abcba (5)
		 */
		String s2 = new StringBuilder(s1).reverse().toString();
		int m = s1.length();
		int n = s2.length();
		
		int dp[][] = new int [m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0||j==0) {
					dp[i][j]=0;
				}else {
					if(s1.charAt(i-1)==s2.charAt(j-1)) {
						dp[i][j]=1+dp[i-1][j-1];
					}else {
						dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
					}
					
				}
			}
		}
		
		return dp[m][n];
	}

	// how LCS will apply here
/*
 * s1 = heap----->s2 = pea
 *    \            /
 *2d   \          /  1 insertion
 *      \        /
 *        LCS(ea)   
 *        
 * s1.length - lcs = number of deletion (4-2) =2
 * s2.length -lcs = number of insertion (3-2) =1
 * 
 * res= number of deletion + number of insertion = (2+1) = 3
 */
	private static int minimun_insertion_deletion(String s1, String s2) {
		
		int m = s1.length();
		int n = s2.length();
		
		int dp[][] = new int [m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0||j==0) {
					dp[i][j]=0;
				}else {
					if(s1.charAt(i-1)==s2.charAt(j-1)) {
						dp[i][j]=1+dp[i-1][j-1];
					}else {
						dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
					}
					
				}
			}
		}
		
		int deletion = m - dp[m][n];
		int insertion = n - dp[m][n];
		
		return deletion +insertion;
	}

	/*
	 * Explanation: 
		String "geeke" has both string "geek" 
		and "eke" as subsequences.
	 */
	private static int shortest_common_super_sequence(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		
		int dp[][] = new int [m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0||j==0) {
					dp[i][j]=0;
				}else {
					if(s1.charAt(i-1)==s2.charAt(j-1)) {
						dp[i][j]=1+dp[i-1][j-1];
					}else {
						dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
					}
					
				}
			}
		}
		
		// geek + eke - ek
		return m+n - dp[m][n];
	}

	private static String print_LCS(String s1, String s2) {

		int m = s1.length();
		int n = s2.length();
		int dp[][] = new int [m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					dp[i][j]=0;
				}else {
					if(s1.charAt(i-1)==s2.charAt(j-1)) {
						dp[i][j] = 1+dp[i-1][j-1];
					}else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
		}
		
		StringBuilder res=new StringBuilder();
		int i=m,j=n;
		while(i>0 ||j>0) {
			if(s1.charAt(i-1)==s2.charAt(j-1)) {
				 res.insert(0, s1.charAt(i-1));
				i--;j--;
			}else {
				if(dp[i][j-1] > dp[i-1][j]) {
					j--;
				}else {
					i--;
				}
			}
		}
		
	return res.toString();
	}

	/*
	 * this is variation of LCS 
	 */
	private static int longest_common_substring(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		
		int dp[][]= new int [m+1][n+1];
		int res=0;
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0||j==0) {
					dp[i][j]=0;
				}
				else if(s1.charAt(i-1) == s2.charAt(j-1)){
					dp[i][j] = 1+dp[i-1][j-1];
					res=Math.max(res, dp[i][j]);
				}else {
					dp[i][j] = dp[i-1][j-1];
				}
			}
		}
		
		return res;
	}

	private static int lcs_dp(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int dp[][] = new int [m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					dp[i][j]=0;
				}else {
					if(s1.charAt(i-1)==s2.charAt(j-1)) {
						dp[i][j] = 1+dp[i-1][j-1];
					}else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
		}
		return dp[m][n];
	}

	private static int lcs_recursive(String s1, String s2, int m, int n) {
		
		if(m==0 || n==0) return 0;
		
		if(s1.charAt(m-1) == s2.charAt(n-1)) {
			return 1+ lcs_recursive(s1, s2, m-1, n-1);
			
		}else {
			return Math.max(lcs_recursive(s1, s2, m, n-1),lcs_recursive(s1, s2, m-1, n));
		}

		
	}
	
private static int lcs_recursive_memo(String s1, String s2, int m, int n,int[][]memo) {
		
		if(m==0 || n==0) return 0;
		
		if(memo[m][n]!=-1) {
			System.out.println("dkjfkdjfdkfjdkjfdjfk");
			return memo[m][n];
		} 
		if(s1.charAt(m-1) == s2.charAt(n-1)) {
			return memo[m][n] =1+ lcs_recursive(s1, s2, m-1, n-1);
			
		}else {
			return memo[m][n]= Math.max(lcs_recursive(s1, s2, m, n-1),lcs_recursive(s1, s2, m-1, n));
		}

		
	}

}
