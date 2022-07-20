package com.leetcode;

public class BinayToDecimal {

	public static void main(String[] args) {
		int a = 1010;
		System.out.println(getDecimal(a));
		
		System.out.println(a%10);
		
		

	}
	
	public static int getDecimal(int binary){  
	    int decimal = 0;  
	    int n = 0;  
	    while(true){  
	      if(binary == 0){  
	        break;  
	      } else {  
	          int temp = binary%10;  
	          decimal += temp*Math.pow(2, n);  
	          binary = binary/10;  
	          n++;  
	       }  
	    }  
	    return decimal;  
	}  

}
