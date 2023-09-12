package com.recursion;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortAnArrayUsingRecursion {
	
	public static void main(String[] args) {

		int [] arr = {0,1,5,2};
		
		print(arr);
		sort(arr, arr.length);
		print(arr);
		}
	
	private static void sort(int []arr,int n) {
		
		if(n<=1) {
			return;
		}
		int val = arr[n-1];
		sort(arr,n-1);
		insert(arr,val,n-1);
		
		
	}
	
	private static void insert(int []arr,int val,int pos) {
		if(pos==0 || arr[pos-1]<=val) {
			arr[pos]= val;
			return;
		}
		int temp = arr[pos-1];
		insert(arr, val, pos-1);
		arr[pos]=temp;
	}
	
	

	private static void print(int[] arr) {
		Arrays.stream(arr).forEach(i -> {
			System.out.print(i+",");
		});
	}
}
