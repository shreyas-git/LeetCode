package com.leetcode;


/*
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */
public class EditDistance_72 {

	public static void main(String[] args) {
		

System.out.println(minDistance("CAT", "CUT"));
	}
	
    public static int minDistance(String word1, String word2) {
    	int m = word1.length()+1;
    	int n = word2.length()+1;
    	
    	int [][] dp = new int[m][n];
    	
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			//Base case 
    			if(i==0) {
    				dp[i][j] = j;
    			}else if (j==0) {
    				dp[i][j] = i;
    			}else {
    				if(word1.charAt(i-1) == word2.charAt(j-1)) {
    					dp[i][j] = dp[i-1][j-1];
    				}else {
    					dp[i][j] =1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
    				}
    			}
    			
    			
    			
    			
    		}
    	}
    	
    	
    	
    	
    	
		return dp[m-1][n-1];
    	
        
    }
	
	public static int minDistanceRecursive(String word1, String word2) {
        if(word1.isEmpty() && word2.isEmpty()){
            return 0;
        }
        if(word1.equals(word2)){
            return 0;
        }
       return  1+edRecursive(word1,word2,word1.length()-1,word2.length()-1);
    }
    
    
    public static int edRecursive(String s1,String s2,int m ,int n){
        
        if(m <=0) return n <0 ?0:n;
        if(n <=0) return m <0 ?0:m;
        
        
        if(s1.charAt(m) == s2.charAt(n)){
            return edRecursive(s1,s2,m-1,n-1);
        }else{
            return 1 + Math.min( edRecursive(s1,s2,m-1,n-1) , Math.min(edRecursive(s1,s2,m-1,n),edRecursive(s1,s2,m,n-1)));
        }
        
    }

}
