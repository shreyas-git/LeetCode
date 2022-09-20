package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {

	public static void main(String[] args) {
		PC pc = new PC();
		Thread producer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					pc.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread consumer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					pc.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		producer.start();
		consumer.start();

	}

}


class PC {
	int capacity = 2;
	LinkedList<Integer> list = new LinkedList<>();
	
	public void produce() throws InterruptedException {
		int value =0;
		while(value <100) {
			synchronized(this) {
				while(list.size()==capacity) {
					wait();
				}
				
				System.out.println("produced ="+value);
				list.add(value++);
				
				
				notify();
			}
			
			
			
		}
		
	
	}
	
	public void consumer() throws InterruptedException {
		while(true) {
			synchronized(this) {
			while(list.size()==0) {
				wait();
			}
			
			System.out.println("consumed="+list.removeFirst());
			
			notify();
			
		}
		}
	}
	
}