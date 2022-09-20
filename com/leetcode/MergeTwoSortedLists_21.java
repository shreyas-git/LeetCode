package com.leetcode;

public class MergeTwoSortedLists_21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
	ListNode temp = new ListNode(0);
	
	ListNode ans = temp;
	
	while(list1 !=null && list2!=null) {
		
		if(list1.val < list2.val) {
			temp.next =list1;
			list1= list1.next;
		}else {
			temp.next= list2;
			list2= list2.next;
		}
		temp= temp.next;
		
	}
	
	if(list1==null) {
		temp.next = list2;
	}
	if(list2==null) {
		temp.next = list1;
	}
	
	return ans.next;
    }

}
