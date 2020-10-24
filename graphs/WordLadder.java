// https://leetcode.com/problems/word-ladder/

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> notVisited = new HashSet<>(wordList);
        LinkedList<String> q = new LinkedList<>();
        
        q.add(beginWord);
        notVisited.remove(beginWord);

        int pathLen = 1;
        while (!q.isEmpty()) {
            int N = q.size();
            for (int i = 0; i < N; i++) {
                String word = q.pollFirst();
                if (word.equals(endWord)) {
                    return pathLen;
                }
                
                for (int j = 0; j < word.length(); j++) {
                    StringBuilder sb = new StringBuilder(word);
                    char saved = word.charAt(j);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        String newWord = sb.toString();
                        if (notVisited.contains(newWord)) {
                            q.add(newWord);
                            notVisited.remove(newWord);
                        }
                    }
                    
                    sb.setCharAt(j, saved);
                }
            }
            
            pathLen++;
        }
        
        return 0;
    }
}