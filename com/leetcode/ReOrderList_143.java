package com.leetcode;

public class ReOrderList_143 {

	public static void main(String[] args) {
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
 
		printList(n1);
 
		reorderList(n1);
 
		printList(n1);

	}

	public static void printList(ListNode n) {
		System.out.println("------");
		while (n != null) {
			System.out.print(n.val);
			n = n.next;
		}
		System.out.println();
	}
	 
	  
	// l1 ->l2 -> l3 .............-> ln  (input) 
	// l1 -> ln -> l1 -> ln-1 ->l2 -> ln-2 ......

	    public static void reorderList(ListNode head) {
	      
	        //Step 1: find middle of the list 
	        ListNode slow = head;
	      ListNode fast = head ;
	      
	      while(fast!=null && fast.next != null){
	        fast = fast.next.next;
	        slow = slow.next;
	        
	        }

	     
	      
	      //step 2 : reverse the second part of the list
	      
	       ListNode second = reverese(slow);
	      
	      //step 3: merge two list 
	      
	      ListNode first = head;
	      
	     while (second.next != null) {
	     ListNode tmp = first.next;
	      first.next = second;
	      first = tmp;

	      tmp = second.next;
	      second.next = first;
	      second = tmp;
	    }
	    }
	  
	  public static ListNode reverese(ListNode head){
	    ListNode prev = null;
	    ListNode cur = head;
	    while(cur!=null){
	      ListNode next = cur.next;
	      cur.next = prev;
	      prev = cur;
	      cur = next;
	    }
	      
	      return prev;
	  }
	  
	  
}





 

  
  
