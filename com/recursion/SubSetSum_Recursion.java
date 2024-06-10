package com.recursion;

public class SubSetSum_Recursion {
    public static void main(String[] args) {
        int [] arr = {10,20,15};
        int sum = 25;
        System.out.println( countSubsets(arr,sum,arr.length));
    }

    private static int countSubsets(int[] arr, int sum, int length) {

        if(length ==0){
            if(sum ==0) return 1;
                return 0;
        }
       int x = countSubsets(arr,sum, length-1);
        int y = countSubsets(arr,sum-arr[length-1],length-1);

        return x + y;
    }
}
