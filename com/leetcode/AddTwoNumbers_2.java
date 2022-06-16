package com.leetcode;

public class AddTwoNumbers_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	 

	    public ListNode addTwoNumbers(ListNode p, ListNode q) {
	        
	        ListNode temp = new ListNode(0);
	        int carry =0 ;
	         ListNode  l1=p,  l2=q;
	        ListNode cur = temp;
	        
	        while(l1 != null || l2 != null){
	            int x = (l1 != null) ? l1.val : 0;
	            int y = (l2 != null) ? l2.val : 0;
	            
	            int sum = x +y + carry;
	            carry = sum/10;
	            cur.next= new ListNode(sum%10);
	            cur = cur.next;
	            if(l1 !=null) l1=l1.next;
	            if(l2 !=null) l2= l2.next;
	        }
	        
	        if(carry >0){
	            cur.next= new ListNode(carry);
	        }
	        
	        return temp.next;
	    }
	}


