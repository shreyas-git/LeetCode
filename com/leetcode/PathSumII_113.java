package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      /*
       *                    5
       *                4       8
       *            11       13   4
       *          7    2        5   1
       *                 
 Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22               
       *                 
       *                 
       *                 
       *                 
       *                 
       *                 
       *                 
       *                 
       *                 
       */
	}
	
	 public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList();
     
    
      dfs(root,targetSum,temp,res);
      
     
    return res;
    }
  
  public static  void dfs(TreeNode root,int target,List<Integer> temp,List<List<Integer>> res){
    if(root == null) return ;

    temp.add(root.val);
    if(root.left == null && root.right == null && root.val == target){
      res.add(new ArrayList<Integer>(temp));
    }else{
          dfs(root.left,target-root.val,temp,res);
      dfs(root.right,target-root.val,temp,res);
    
    }
  
   temp.remove(temp.size()-1);
   
  }

}
