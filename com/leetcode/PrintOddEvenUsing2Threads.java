package com.leetcode;

public class PrintOddEvenUsing2Threads {

	public static void main(String[] args) throws InterruptedException {
		SharedPrinter printer= new SharedPrinter();
		
		Thread odd = new Thread(new OddThread(printer,100));
		
		Thread even = new Thread(new EvenThread(printer,100));
		
		odd.start();
		even.start();
		
		
		//odd.join();

	}

	
	
}

 class OddThread implements Runnable{

	SharedPrinter printer;
	int max_value;
	
	
	public OddThread(SharedPrinter printer, int max_value) {
		super();
		this.printer = printer;
		this.max_value = max_value;
	}


	@Override
	public void run() {
		
		for(int i=1;i<max_value;i=i+2) {
			try {
				printer.printOdd(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
}

 class EvenThread implements Runnable{

	SharedPrinter printer;
	int max_value;
	
	public EvenThread(SharedPrinter printer, int max_value) {
		super();
		this.printer = printer;
		this.max_value = max_value;
	}
	@Override
	public void run() {
		
	for(int i=2;i<max_value;i=i+2) {
				try {
					printer.printEven(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
	}
	
}

 class SharedPrinter{
	
	public SharedPrinter() {}
	
	boolean is_odd = true;
	
	
	public  synchronized void printEven(int val) throws InterruptedException {
		
		if(is_odd) {
			
			
			wait();
		}
		System.out.println("Even:"+val);
		is_odd = !is_odd;
		
		notify();
		
	}
	
	public synchronized void printOdd(int val) throws InterruptedException {
		if(!is_odd) {
			
			
			wait();
			
		}
		System.out.println("Odd:"+val);
		is_odd = !is_odd;
		
		notify();
		
	}
	
}


