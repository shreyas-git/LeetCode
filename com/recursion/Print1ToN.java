package com.recursion;

public class Print1ToN {

	public static void main(String[] args) {
		print1ToN(5);
		printNTo1(5);
	}

	private static void printNTo1(int i) {
		
		if(i>0) {
			System.out.println(i);
			printNTo1(i-1);
		}
		
		
		
	}

	private static void print1ToN(int i) {
		
		if(i>0) {
			print1ToN(i-1);
			System.out.println(i);
		}
			
		
	}
}
