package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.

There are two types of logs:

Letter-logs: All words (except the identifier) consist of lowercase English letters.
Digit-logs: All words (except the identifier) consist of digits.
Reorder these logs so that:

The letter-logs come before all digit-logs.
The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
The digit-logs maintain their relative ordering.
Return the final order of the logs.
 */
public class ReorderDatainLogFiles_937 {

	public static void main(String[] args) {
		String [] logs  = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
		System.out.println(reorderLogFiles(logs));
		
		for(String log:logs) {
			System.out.print(log + " ");
		}
	}
	
	
	public static String[] reorderLogFiles(String[] logs) {
        
	      
	      Comparator<String> comparator = new Comparator<String>() {

			@Override
			public int compare(String log1, String log2) {
				   String [] split1 = log1.split(" ",2);
				   String [] split2 = log2.split(" ",2);
				   
				   boolean  isDigit1 = Character.isDigit(split1[1].charAt(0));
				   boolean  isDigit2 = Character.isDigit(split2[1].charAt(0));
				   
				   
				 // both are letter , Then sort lexiographically 
				   
				   if(!isDigit1 && !isDigit2) {
					   int cmp = split1[1].compareTo(split2[1]);
	                    if (cmp != 0)
	                        return cmp;
	                    // logs of same content, compare the identifiers
	                    return split1[0].compareTo(split2[0]);
				   }
				   
				   // case 2). one of logs is digit-log
	                if (!isDigit1 && isDigit2)
	                    // the letter-log comes before digit-logs
	                    return -1;
	                else if (isDigit1 && !isDigit2)
	                    return 1;
	                else
	                    // case 3). both logs are digit-log
	                    return 0;
				
				
			}
		};
		
		
		Arrays.sort(logs,comparator);
		
		return logs;
	    }

}
