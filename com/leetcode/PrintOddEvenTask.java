package com.leetcode;

public class PrintOddEvenTask {

	public static void main(String[] args) {
		
		Printer print = new Printer();
	    Thread t1 = new Thread(new TaskEvenOdd(print, 10, false),"Odd");
	    Thread t2 = new Thread(new TaskEvenOdd(print, 10, true),"Even");
	    t1.start();
	    t2.start();



	}

}


class TaskEvenOdd implements Runnable {
    private int max;
    private Printer print;
    private boolean isEvenNumber;

    

	public TaskEvenOdd( Printer print,int max, boolean isEvenNumber) {
		super();
		this.max = max;
		this.print = print;
		this.isEvenNumber = isEvenNumber;
	}



	// standard constructors

    @Override
    public void run() {
        int number = isEvenNumber ? 2 : 1;
        while (number <= max) {
            if (isEvenNumber) {
                print.printEven(number);
            } else {
                print.printOdd(number);
            }
            number += 2;
        }
    }
}

class Printer {
    private  boolean isOdd;

    synchronized void printEven(int number) {
        if (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = false;
        notify();
    }

    synchronized void printOdd(int number) {
        if (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = true;
        notify();
    }
}

