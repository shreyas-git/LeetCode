package com.leetcode;

import java.util.PriorityQueue;

public class FindMedianFromDataStream_295 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(1);    // arr = [1]
		medianFinder.addNum(2);    // arr = [1, 2]
		System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
		medianFinder.addNum(3);    // arr[1, 2, 3]
		System.out.println(medianFinder.findMedian()); // return 2.0
	}

}

// 1    2    3    4    5    6    7 
// |maxHeap     |   | min heap   |
//   n/2 sorted       n/2 sorted
class MedianFinder {

	  PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);// decending order 
	  PriorityQueue<Integer>minHeap = new PriorityQueue<>();// ascending order
	  int totalNum=0;
	  
	    public MedianFinder() {
	        
	    }
	    
	    public void addNum(int num) {
	         totalNum++;
	      if(maxHeap.isEmpty()){
	        maxHeap.offer(num);
	        return;
	      }
	      if(minHeap.isEmpty() && num >= maxHeap.peek()){
	        minHeap.offer(num);
	        return ;
	      }
	      
	      if(num < maxHeap.peek()){
	        if(maxHeap.size() - minHeap.size() > 0){
	          minHeap.offer(maxHeap.poll());
	        }
	        maxHeap.offer(num);
	      }else if(num > minHeap.peek()){
	        if(!(minHeap.size() < maxHeap.size())){
	          maxHeap.offer(minHeap.poll());
	        }
	        minHeap.offer(num);
	      }else {
	        if(maxHeap.size() - minHeap.size() > 0){
	          minHeap.offer(num);
	        }
	        else{
	          maxHeap.offer(num);
	        }
	      }
	     
	    }
	    
	    public double findMedian() {
	        if(totalNum%2==0){
	          //even
	          return (double) (maxHeap.peek() + minHeap.peek())/2;
	        }else{
	          //odd
	          return (double)(maxHeap.peek());
	        }
	    }
	}

	/**
	 * Your MedianFinder object will be instantiated and called as such:
	 * MedianFinder obj = new MedianFinder();
	 * obj.addNum(num);
	 * double param_2 = obj.findMedian();
	 */