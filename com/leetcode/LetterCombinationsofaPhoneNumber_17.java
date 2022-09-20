package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class LetterCombinationsofaPhoneNumber_17 {

	public static void main(String[] args) {
		
System.out.println(letterCombinations("123"));

	}

	public static  List<String> letterCombinations(String digits) {
        List<String> res= new ArrayList();
        
        if(digits==null || digits.length()==0)
        {
            return res;
        }
        StringBuilder temp = new StringBuilder();
        
        Map<Character,char[]> dict = new HashMap<>();
      
        dict.put('0',new char[]{'0'});
        dict.put('1',new char[]{'1'});
        dict.put('2',new char[]{'a','b','c'});
        dict.put('2',new char[]{'a','b','c'});
        dict.put('3',new char[]{'d','e','f'});
        dict.put('4',new char[]{'g','h','i'});
        dict.put('5',new char[]{'j','k','l'});
        dict.put('6',new char[]{'m','n','o'});
        dict.put('7',new char[]{'p','q','r','s'});
        dict.put('8',new char[]{'t','u','v'});
        dict.put('9',new char[]{'w','x','y','z'});
      
        helper(digits,temp,res,dict,0);
      
      return res;
    }
  
  
  public static  void helper(String digits,StringBuilder temp,List<String> res,Map<Character,char[]> dict,int index){
    
    if(temp.length() == digits.length()){
      res.add(temp.toString());
      return ;
    }
    
    char number = digits.charAt(index);
    char [] values = dict.get(number);
    
    for(int i =0;i<values.length;i++){
      temp.append((values[i]));
     helper(digits,temp,res,dict,index+1);
      temp.deleteCharAt(temp.length()-1);
    }
  }
}
