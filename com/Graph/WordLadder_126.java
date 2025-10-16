package com.Graph;

import java.util.*;

public class WordLadder_126 {

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord = "hit", endWord = "cog";
        List<List<String>> result = findLadders(beginWord, endWord, wordList);
        System.out.println("All shortest paths:");
        for (List<String> path : result) {
            System.out.println(path);
        }
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList();

        Set<String> wordSet = new HashSet<>(wordList);

        if(!wordSet.contains(endWord)) return result;

        Map<String , List<String>> graph = new HashMap();
        Map<String, Integer> distance = new HashMap();

        // create graph and dist map
        bfs(beginWord, endWord, wordSet, graph, distance);

        List<String> path = new ArrayList<>();
        path.add(beginWord);

        dfs(beginWord, endWord, graph, distance, path, result);

        return result;
    }

    private static void dfs(String current, String endWord, Map<String, List<String>> graph,Map<String, Integer> distance, List<String> temp, List<List<String>> result){

        if(current.equals(endWord)){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(String neighbor: graph.get(current)){

            if(distance.get(current) +1 == distance.get(neighbor)){
                temp.add(neighbor);
                dfs(neighbor,endWord,graph,distance,temp,result);
                temp.remove(temp.size() -1);
            }
        }


    }

    public static void bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> graph, Map<String, Integer> distance) {

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord,0);

        graph.put(beginWord, new ArrayList<>());

        for(String word:wordSet){
            graph.put(word, new ArrayList<>());
        }

        while(!queue.isEmpty()){

            String current = queue.poll();
            int currDistance = distance.get(current);

            for(String neighbor : getNeighbors(current,wordSet)){
                graph.get(current).add(neighbor);

                if(!distance.containsKey(neighbor)){
                    distance.put(neighbor,currDistance+1);
                    queue.offer(neighbor);
                }

            }
        }

    }

    static List<String> getNeighbors(String word, Set<String> wordSet) {

        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == original) continue;
                chars[i] = c;
                String newWord = String.valueOf(chars);
                if (wordSet.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }
            chars[i] = original;
        }

        return neighbors;
    }

}
