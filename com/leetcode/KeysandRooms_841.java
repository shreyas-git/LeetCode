package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise
 */


/*
 * Example 1:

Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation: 
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.
Example 2:

Input: rooms = [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
 */
public class KeysandRooms_841 {

	public static void main(String[] args) {
		
				
				List<List<Integer>> rooms = new ArrayList<>();
				List<Integer> list1 = new ArrayList<>();
				list1.add(1);list1.add(3);
				rooms.add(list1);
				List<Integer> list2 = new ArrayList<>();
				list2.add(3);list2.add(0);list2.add(1);
				rooms.add(list2);
				List<Integer> list3 = new ArrayList<>();
				list3.add(2);
				rooms.add(list3);
				List<Integer> list4 = new ArrayList<>();
				rooms.add(list4);
				
				System.out.println(canVisitAllRooms(rooms));
				
				

	}
	
public static  boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean[] visited = new boolean[rooms.size()];
        
        visited[0] = true;
        
        Queue<Integer> queue = new LinkedList();
        
        queue.add(0);
        while(!queue.isEmpty()){
            int index = queue.remove();
            
            for(int key:rooms.get(index)){
                if(!visited[key]){
                    visited[key] = true;
                    queue.add(key);
                }
            }
        }
            
            
            for(boolean b:visited){
                if(!b) return false;
            }
        
        return true;
        }

}
