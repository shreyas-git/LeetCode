package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.



Example 1:


Input: board = [["o","a","a","n"],
                 ["e","t","a","e"],
                 ["i","h","k","r"],
                 ["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
 */
public class WordSearch_212 {
    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(board,words));
    }


    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board == null || board.length ==0 ) {
            return res;
        }
        TrieNode root = new TrieNode();
        buildTrie(root,words);

        for(int i=0;i< board.length;i++){
            for(int j=0;j< board[0].length;j++){
                char c = board[i][j];
                if(root.children[c - 'a'] != null){
                    dfs(board,i,j,root,res);
                }
            }
        }

        return res;
    }

    private static void dfs(char[][] board, int i, int j, TrieNode cur, List<String> res){

        if(i< 0 || j<0 || i >= board.length || j >= board[0].length) return ;

        if(board[i][j] == '#') return;
        char c = board[i][j];

        if(cur.children[c -'a'] == null) return ;

        cur = cur.children[c -'a'];
        if(cur.word !=null){
            res.add(cur.word);
            cur.word =null;
        }

        board[i][j] = '#';
        dfs(board,i+1,j,cur,res);
        dfs(board,i-1,j,cur,res);
        dfs(board,i,j+1,cur,res);
        dfs(board,i,j-1,cur,res);

        board[i][j] = c;

    }

    private static void buildTrie(TrieNode root, String[] words) {
        for(String s:words){
            TrieNode cur = root;

            for(char c:s.toCharArray()){
                int index = (int) c -'a';
                if(cur.children[index] == null){
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.word = s;
        }
    }



}

class TrieNode {
    TrieNode[] children;
    String word;
    public TrieNode() {
        children = new TrieNode[26];
        word = null;
    }
}