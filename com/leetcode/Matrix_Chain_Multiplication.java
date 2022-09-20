package com.leetcode;

public class Matrix_Chain_Multiplication {

/*
 we will be having an string or array 
 
  int solve(int []arr, int i ,int j){
  
  //base condition 
   if(i>j){
   		return 0;
   		
   }
   
   for(int k=i;k<j;k++){
     int temp = solve(arr,i,k) + solve(arr,k+1,j)......etc, depending on the case 
     
     ans = caclulate with (temp and  ans);
   }
   
   return ans;
  }

 */
	public static void main(String[] args) {
		
		int [] arr= {40,20,30,10,30};
		System.out.println("MCM="+solve(arr,1,arr.length-1));
		
	}

	private static int solve(int[] arr, int i, int j) {
		// base condition 
		if(i>=j)return 0;
		
		// move k -> i to j 
		int min = Integer.MAX_VALUE;
		for(int k=i;k<=j-1;k++) {
		int temp = solve(arr,i,k) +solve(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
			
			if(temp<min) {
				min = temp;
			}
		}
		
		return min;

	}
	
	
	
	

}
