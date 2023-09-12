package com.recursion;

public class TowerOfHanoi {
	static int count =0;
	public static void main(String[] args) {
		
		int N = 3;
		
		
		 towerOfHanoi(N, 'A', 'C', 'B');
		 System.out.println("Total count ="+count);
	}

	private static void towerOfHanoi(int n, char from, char to, char helper) {
		count++;
		if(n==1) {
			System.out.println("MOVED Disk = "+ n +"  from ="+from + " to ="+to );
			return ;
		}
			
		
		towerOfHanoi(n-1, from, helper, to);
		System.out.println("MOVED Disk = "+ n +"  from ="+from + " to ="+to );
		
		towerOfHanoi(n-1, helper, to, from);
		
		
		
	}

}
