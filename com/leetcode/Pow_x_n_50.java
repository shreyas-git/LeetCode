package com.leetcode;

public class Pow_x_n_50 {

	public static void main(String[] args) {
		double x = 2.00000;int  n = 10;
		
		System.out.println(myPow(x, n));

	}
	
	 public static  double myPow(double x, int n) {
	       
	     //2-2 = 1/22 = 1/4 = 0.25
	        long N = n;
	        
	        if(N<0){
	            x = 1/x;
	            N= N*-1;
	        }
	        
	        return findPow(x,N);
	    }
	    
	    
	    public static  double findPow(double x,long n){
	        
	        if(n==0){
	            return 1;
	        }
	        
	        double half = findPow(x , n/2);
	        if(n%2==0){
	            return half*half;
	        }else{
	            return half*half*x;
	        }
	    }

}
