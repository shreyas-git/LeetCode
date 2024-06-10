package com.recursion;



import java.util.ArrayList;
import java.util.List;

public class GenerateSubSets {
    public static void main(String[] args) {
        String str= "ABC";
        List<String> res = new ArrayList<>();
        findSubSet(str,new String(),0);

       // return res;
    }

    private static void findSubSet(String str, String cur, int start) {

        if(str.length() == start){
            System.out.println(cur);
            return;
        }

        findSubSet(str, cur,start+1);
        findSubSet(str,cur+str.charAt(start),start+1);


    }
}
