package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParentheses_22 {

	public static void main(String[] args) {
		
		System.out.println(generateParenthesis(2));
	}

	public static  List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        util(n,0,0,new StringBuilder(),res);
        
        return res;
    }
    
    public static void util(int n,int l, int r,StringBuilder sb, List<String> res){
        if(l==n && r==n){
            res.add(sb.toString());
            return ;
        }
        
        if(l<n){
            sb.append("(");
            util(n,l+1,r,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(r<l){
            sb.append(")");
            util(n,l,r+1,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}
