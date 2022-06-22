package com.leetcode;

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
		
		
		if(!wordList.contains(endWord)) {
			return 0;
			
		}
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
			
			for(int i=0;i<size;i++) {
				String curr_word = queue.poll();
				
				char[] word_chars = curr_word.toCharArray();
				
				for(int j=0;j<word_chars.length;j++) {
					char original = word_chars[j];
					
					for(char c='a' ;c<'z' ;c++) {
						if(word_chars[j] == c) continue;
						word_chars[j] = c;
						
						String new_word = String.valueOf(word_chars);
						if(new_word.equals(endWord)) {
							return level+1;
						}
						if(set.contains(new_word)) {
							queue.offer(new_word);
							set.remove(new_word);
						}
					}
					
					
					word_chars[j] = original;
				}
				
			}
			
			
			level++;
		}
		
		return 0;
	}

}
