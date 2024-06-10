package com.leetcode;

/*
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 */
public class ValidPalindrom2_680 {

	/*
	 * Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Input: s = "abc"
Output: false
	 */
	public static void main(String[] args) {


    System.out.println(validPalindrome("abcbxXa"));
	}
	
	

    private static  boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            
            i++;
            j--;
        }
        //"abcbxXa"
        return true;
    }
    
    
    public static  boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
            // Found a mismatched pair - try both deletions
            if (s.charAt(i) != s.charAt(j)) {
                return (checkPalindrome(s, i, j - 1) || checkPalindrome(s, i + 1, j));
            }
            
            i++;
            j--;
        }
        
        return true;
    }


}
