// https://leetcode.com/problems/implement-trie-prefix-tree/

public class Trie 
{
    class TrieNode 
    {
        String word;
        boolean endOfWord;
        TrieNode[] letters;
        
        public TrieNode() 
        {
            endOfWord = false;
            letters = new TrieNode[26];
        }
    }
    
    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() { root = new TrieNode(); }
    
    /** Inserts a word into the trie. */
    public void insert(String word) 
    {
        TrieNode currNode = root;
        TrieNode newNode;
        int index;
        for (int i = 0; i < word.length(); i++) 
        {
            index = word.charAt(i) - 'a';
            if (currNode.letters[index] == null) 
            {
                newNode = new TrieNode();
                currNode.letters[index] = newNode;
            }

            currNode = currNode.letters[index];
        }
        
        currNode.word = word;
        currNode.endOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) 
    {
        TrieNode currNode = root;
        int index;
        for (int i = 0; i < word.length(); i++) 
        {
            index = word.charAt(i) - 'a';
            if (currNode.letters[index] == null) {
                return false;
            } else {
                currNode = currNode.letters[index];
            }
        }
        
        return currNode.endOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) 
    {
        TrieNode currNode = root;
        int index;
        for (int i = 0; i < prefix.length(); i++) 
        {
            index = prefix.charAt(i) - 'a';
            if (currNode.letters[index] == null)
                return false;
            else
                currNode = currNode.letters[index];
        }
        
        return true;
    }
}