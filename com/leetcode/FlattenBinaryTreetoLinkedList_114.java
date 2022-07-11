package com.leetcode;

import java.util.Stack;

public class FlattenBinaryTreetoLinkedList_114 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void flatten(TreeNode root) {
	      // Go to left of the tree , when the right child id not null then push it into the stack
	        Stack<TreeNode> stack = new Stack();
	      
	      TreeNode cur= root;
	      
	      while(cur!=null || !stack.isEmpty()){
	        if(cur.right!=null){
	          stack.push(cur.right);
	          
	        }
	        
	        if(cur.left!=null){
	          cur.right = cur.left;
	          cur.left = null;
	        }else if(!stack.isEmpty()){
	          TreeNode temp = stack.pop();
	          cur.right = temp;
	        }
	        
	        cur = cur.right;
	      }
	      
	    }
}
