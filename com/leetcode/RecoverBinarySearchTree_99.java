package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.


 */
public class RecoverBinarySearchTree_99 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,3,2,4};//{1,2,9,5,6,7,8,4,10};
		
		
/*             3
 *           /   \
 *          1     4
 *               /
 *              2 
 *        
 * 
 */
		
		TreeNode node3 = new TreeNode(3);
		node3.left = new TreeNode(1);
		node3.right = new TreeNode(4);
		node3.right.left = new TreeNode(2);
		inorder(node3, new ArrayList<Integer>());
		
		recoverTree(node3);
		System.out.println();
		inorder(node3, new ArrayList<Integer>());
	}
	public static void recoverTree(TreeNode root) {
	       List<Integer> nums = new ArrayList();
	      inorder(root,nums);
	      
	      int []swapped = getSwapped(nums);
	      reOrder(root,swapped[0],swapped[1],2);
	      
	    }
	  
	  public static void reOrder(TreeNode root, int x, int y , int count){
	    if(root!=null){
	       if(root.val == x || root.val == y){
	      
	         
	         if(root.val==x){
	           root.val=y;
	         }else{
	            root.val=x;
	         }
	      if(--count == 0) return ;
	    }
	     reOrder(root.left,x,y,count);
	    reOrder(root.right,x,y,count);
	    }
	    
	   
	  }
	  
	  public static int[] getSwapped(List<Integer> list){
	    int x=-1,y=-1;
	    boolean isSwapped=false;
	    
	    for(int i=0;i<list.size()-1;i++){
	      if(list.get(i) > list.get(i+1)){
	        y = list.get(i+1);
	        
	        if(!isSwapped){
	          x = list.get(i);
	          isSwapped= true;
	        }
	        
	      }
	    }
	    System.out.println();
	    System.out.println("x= "+ x);
		System.out.println("y = "+y);
	    return new int[]{x,y};
	  }
	  
	  public static void inorder(TreeNode root, List<Integer> list){
	    if(root!=null){
	       inorder(root.left,list);
	    list.add(root.val);
	    System.out.print(root.val+" ");
	    inorder(root.right,list);
	    } 
	    
	   
	  }
}
