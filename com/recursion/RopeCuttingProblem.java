package com.recursion;

public class RopeCuttingProblem {
    public static void main(String[] args) {
        int n =23, a= 11, b = 9 , c=12 ;
        System.out.println( findCuts(n,a,b,c));
    }

    private static int findCuts(int n, int a, int b, int c) {

        if(n==0) return 0;
        if(n < 0) return -1;
          int res = max(findCuts(n-a,a,b,c),
                        findCuts(n-b,a,b,c),
                        findCuts(n-c,a,b,c));
          if(res == -1 ){
              return -1;
          }else{
              return res+1;
          }
    }

    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(c,b));
    }
}
