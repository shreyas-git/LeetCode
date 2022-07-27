package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountMerge_721 {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		
	String [][] acc= 	{{"John","johnsmith@mail.com","john_newyork@mail.com"},{"John","johnsmith@mail.com","john00@mail.com"},{"Mary","mary@mail.com"},{"John","johnnybravo@mail.com"}};
	List<List<String>> list = Arrays.stream(acc)
            .map(Arrays::asList)
            .collect(Collectors.toList());
	
	sol.accountsMerge(list);
	System.out.println(list);
	}

}



class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
      
      if(accounts.size() <1) return res;
      
      Map<String, HashSet<String>>  graph = new HashMap<>();
      Map<String,String> emailToName = new HashMap();
      
      // step 1 : build a graph
      
      buildGraph(accounts,graph,emailToName);
      
      //System.out.println(graph);
      
      Set<String> visited = new HashSet<>();
      
      for(String mail: emailToName.keySet()){
        List<String> mails = new ArrayList<>();
         if(visited.add(mail)){
            mails.add(mail);
           dfs(mails,graph,mail,visited);
           
           Collections.sort(mails);
           mails.add(0,emailToName.get(mail));
           res.add(mails);
         }
          
      }
      
      
      return res;
    }
  
  
  public void dfs(List<String> mails, Map<String,HashSet<String>> graph,String mail,Set<String> visited){
    
    if(graph.get(mail).size() == 0){
     
      return;
    } 
    
    
    for(String neighbour: graph.get(mail)){
      
      if(!visited.contains(neighbour)){
        visited.add(neighbour);
        mails.add(neighbour);
        dfs(mails,graph,neighbour,visited);
        
      }
    }
    
  }
  
  private void buildGraph(List<List<String>> accounts, Map<String,HashSet<String>> graph,Map<String,String> emailToName){
    
    for(List<String> account :accounts){ //{{"John","johnsmith@mail.com","john_newyork@mail.com"}

      String name = account.get(0);
      boolean isFirst = true;
      for(int i=1;i<account.size();i++){ //"johnsmith@mail.com","john_newyork@mail.com"
        
        String mail = account.get(i);
        
        emailToName.put(mail,name);
        graph.putIfAbsent(mail,new HashSet<>()); 
        
        if(isFirst){
          isFirst = false;
          continue;
        }
        
        String prevMail = account.get(i-1); 
        graph.get(prevMail).add(mail);
        graph.get(mail).add(prevMail);
      
        
        
        
        
      }
    }
  }
}