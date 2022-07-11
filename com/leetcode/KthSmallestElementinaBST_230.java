package com.leetcode;

import java.util.Stack;

/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.


Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
 */
public class KthSmallestElementinaBST_230 {

	public static void main(String[] args) {
		TreeNode node_1 = new TreeNode(1);
		TreeNode node_2 = new TreeNode(2);
		TreeNode node_3 = new TreeNode(3);
		TreeNode node_4 = new TreeNode(4);
		TreeNode node_5 = new TreeNode(5);
		TreeNode node_6 = new TreeNode(6);
		
		node_5.left= node_3;
		node_5.right = node_6;
		
		node_3.left = node_2;
		node_3.right = node_4;
		
		node_2.left = node_1;
		
		System.out.println(kthSmallest(node_5, 3));
		

	}
	//     5
	//   3   6
	// 2   4  
	//1
	
	/*
	 * Do inorder then 123456
	 * return kth element
	 */
	 public static  int kthSmallest(TreeNode root, int k) {
	        Stack<TreeNode> stack = new Stack<>();
	        TreeNode cur = root;
	        while(cur!=null || !stack.isEmpty()){
	          while(cur!=null){
	            stack.push(cur);
	            cur= cur.left;
	          }
	          cur = stack.pop();
	          k--;
	          if(k == 0){
	            return cur.val;
	          }
	          cur = cur.right;
	        }
	      
	      return -1;
	    }

}



