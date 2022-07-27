package com.leetcode;

public class WordDictionary_211 {

	public static void main(String[] args) {
		
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search("pad")); // return False
		System.out.println(wordDictionary.search("bad")); // return True
		System.out.println(wordDictionary.search(".ad")); // return True
		System.out.println(wordDictionary.search("b..")); // return True

	}

}


class WordDictionary {
	  class TrieNode{
	    public TrieNode [] children;
	    public boolean isWord;
	    
	    public TrieNode(){
	      children  = new TrieNode[26];
	      isWord = false;
	    }
	  }

	 private  TrieNode root;
	  
	    public WordDictionary() {
	        root = new TrieNode();
	    }
	    
	    public void addWord(String word) {
	       
	     
	    	TrieNode cur = root;
		     
		     for(char c : word.toCharArray()){
		       int index = c - 'a';
		       if(cur.children[index] == null){
		         cur.children[index] = new TrieNode();
		       }
		         cur = cur.children[index];
		       
		     }
		     cur.isWord = true;
	      
	    }
	  
	    
	   

		public boolean search(String word) {
	      TrieNode cur = root;
	        return find(word,0,cur);
	    }
	  
	  
	  private boolean find(String word,int index,TrieNode cur){
	    
	    if(index == word.length())  return cur.isWord;
	    
	    char c = word.charAt(index);
	    
	    if(c == '.'){
	      // try with all possible combination from a -> z
	      for(int i=0;i<26;i++){
	          if(cur.children[i]!=null){
	            if(find(word,index+1,cur.children[i])) return true;
	          }
	          
	      }
	      return false;
	    }else{
	      int p = c -'a';
	      
	        return cur.children[p]!=null &&  find(word,index+1,cur.children[p]);
	      
	    }
	    
	  }
	}

	/**
	 * Your WordDictionary object will be instantiated and called as such:
	 * WordDictionary obj = new WordDictionary();
	 * obj.addWord(word);
	 * boolean param_2 = obj.search(word);
	 */
