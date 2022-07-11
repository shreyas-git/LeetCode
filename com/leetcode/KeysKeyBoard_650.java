package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class KeysKeyBoard_650 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(minStepsEasy(3));
	}
	
	 public static int minStepsEasy(int n) {
	        
	        int[] dp = new int[n+1];
	        dp[1] = 0;
	        
	        for (int i = 2; i <= n; i++) {
	            dp[i] = i;
	            for (int j = 1; j < i; j++) {
	                if (i % j == 0)
	                    dp[i] = Math.min(dp[i], dp[j]+i/j);
	            }
	        }
	        
	        return dp[n];
	        
	    }
	
	public static int minStepsDP(int n) {
		return solve(1, 0, n, new HashSet<int[]>());
	}
	
	public static int solve(int i , int j,int n,Set<int[]> visited) {
		if(i>n) {
			return -1;
		}
		if(i==0) return 0;
		if(!visited.contains(new int[] {i,j})) {
	
			visited.add(new int[] {i,j});
		}else {
			return j;
		}
		
		int op1 = 1+ solve(i,i,n,visited);
		
		int op2 = 1+ solve(i+j,j,n,visited);
		
		return Math.min(op1, op2);
	}
	public  static int minSteps(int n) {
        int[] dp=new int[n+1];
        for(int i=1;i<dp.length;i++)
        {
            int x=dp[i]+1;
            for(int j=i+i;j<dp.length;j=j+i)
            {
                dp[j]=Integer.MAX_VALUE;
                if(j-i==i)
                {
                    dp[j]=x+1;
                }
                else
                {
                    dp[j]=dp[j-i]+1;
                }
            }
        }
        // dis(dp);
        return dp[n];
    }
    public static void dis(int[] dp)
    {
        for(int i=0;i<dp.length;i++)
        {
            System.out.println(dp[i]);
        }
    }

}
