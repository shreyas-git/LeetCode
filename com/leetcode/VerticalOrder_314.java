package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrder_314 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        Map<Integer,ArrayList<Integer>>  map  = new TreeMap<>();
        fillUpVerticalOrder(root,0,map);
        
       map.entrySet().forEach(entry -> {
     res.add(entry.getValue());
});

        return res;
        
    }
    
    public void fillUpVerticalOrder(TreeNode node,int horizontalDistance,Map<Integer,ArrayList<Integer>> map){
        if(node== null) return ;
        
        Queue<QueueEntry> queue = new LinkedList();
        queue.add(new QueueEntry(node,horizontalDistance));
        
        while(!queue.isEmpty()){
            QueueEntry entry = queue.poll();
            
            if(map.containsKey(entry.horizontalDistance)){
                ArrayList<Integer> list = map.get(horizontalDistance);
                list.add(node.val);
                map.put(entry.horizontalDistance,list);
                
            }else{
                map.put(entry.horizontalDistance,new ArrayList<Integer>(node.val));
            }
            
            
            if(entry.node.left!=null){
                queue.add(new QueueEntry(entry.node.left,horizontalDistance-1));
            }
            if(entry.node.right!=null){
                queue.add(new QueueEntry(entry.node.right,horizontalDistance+1));
            }
        }
        
    }
    
    
  class QueueEntry{
        TreeNode node;
        int horizontalDistance;
        QueueEntry(TreeNode node, int horizontalDistance)
        {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }  

	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
}




 
 









