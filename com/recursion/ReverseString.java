package com.recursion;

public class ReverseString {
    public static void main(String[] args) {
        String str ="Shreyas";
        reverseString(str,str.length(),0);
    }

    private static void reverseString(String str, int length , int index) {

        if(index==length){
            return;
        }

        if(length >= 0){
            char s = str.charAt(index);
            reverseString(str,length,index+1);
            System.out.println(s);
        }

    }
}
