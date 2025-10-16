package com.Graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder_127 {

	public static void main(String[] args) {
//		List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
//		String beginWord = "hit", endWord = "cog";
//		
		
		List<String> list = Arrays.asList("hot",  "dog");
		String beginWord = "hot", endWord = "dog";
		System.out.println("res = "+ladderLength(beginWord, endWord, list));
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		
		// base cases
		//1. is endword not exists in the dictionary
		if(!wordList.contains(endWord)) {
			return 0;
			
		}
		// create set for removing duplicates and faster search
		Set<String> set = new HashSet();
		for(String word :wordList) {
			set.add(word);
		}
		
		if(set.contains(beginWord)) {
			set.remove(beginWord);
		}
		
		Queue<String> queue = new LinkedList();
		queue.offer(beginWord);
		int level = 1;
		
		
		while(!queue.isEmpty()) {
			int  size = queue.size();

			// this for loop is needed for traversing each level
			/*
			Each arrow is one transformation. The level variable counts these steps.
Level 1: "hit" → queue has 1 word
Level 2: "hot" → queue has 1 word
Level 3: "dot", "lot" → queue has 2 words
Level 4: "dog", "log" → queue has 2 words
Level 5: "cog" → found!
The for (int i = 0; i < size; i++) loop ensures that each level is processed completely before moving to the next,
 so level accurately reflects the number of transformations.
			 */
			for(int i=0;i<size;i++) {
				String curr_word = queue.poll();

				char[] word_chars = curr_word.toCharArray();
				
				for(int j=0;j<word_chars.length;j++) {
					char original = word_chars[j];
					
					for(char c='a' ;c<'z' ;c++) {
						if(word_chars[j] == c) continue;
						word_chars[j] = c; //changing value here ***
						
						String new_word = String.valueOf(word_chars);
						if(new_word.equals(endWord)) {
							return level+1;
						}
						if(set.contains(new_word)) {
							queue.offer(new_word);
							set.remove(new_word);
						}
					}
					
					
					word_chars[j] = original;  // restoring value here
				}
				
			}
			
			
			level++;
		}
		
		return 0;
	}

}
