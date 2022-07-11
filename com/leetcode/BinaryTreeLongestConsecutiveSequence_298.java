package com.leetcode;

public class BinaryTreeLongestConsecutiveSequence_298 {

	public static void main(String[] args) {
		TreeNode node_1 = new TreeNode(1);
		TreeNode node_2 = new TreeNode(2);
		TreeNode node_3 = new TreeNode(3);
		TreeNode node_4 = new TreeNode(4);
		TreeNode node_5 = new TreeNode(5);
		
//		node_1.right = node_3;
//		node_3.left = node_2;
//		node_3.right = node_4;
//		node_4.right = node_5;
		
		node_1.left = node_2;
		node_1.right = node_3;
		
		System.out.println(longestConsecutive(node_1));

	}

	 static int   max =0;
	    public static  int longestConsecutive(TreeNode root) {
	        
	        preOrder(root);
	      
	      return max;
	    }
	  
	  public static  int preOrder(TreeNode root){
	    if(root == null) return 0;
	      
	    int leftMax = preOrder(root.left);
	    int rightMax = preOrder(root.right);
	    
	    int leftTotal =0;
	    if(root.left == null){
	      leftTotal =1;
	    }else if(root.val+1 == root.left.val){
	      leftTotal = leftMax+1;
	      System.out.println(root.left.val);
	    }else{
	      leftTotal =1;
	    }
	    
	    
	    int rightTotal = 0;
	    
	    if(root.right == null){
	      rightTotal = 1;
	    }else if(root.val +1 == root.right.val){
	      rightTotal = rightMax +1;
	      System.out.println(root.right.val);
	    }else{
	      rightTotal = 1;
	    }
	    
	    max = Math.max(max,leftTotal);
	    max = Math.max(max,rightTotal);
	    
	    return Math.max(leftTotal,rightTotal);
	  }
}
