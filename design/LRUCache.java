// https://leetcode.com/problems/lru-cache/

import java.util.LinkedList;
import java.util.HashSet;

public class LRUCache 
{
    public class Node 
    {
        int key;
        int val;
        public Node(int key, int val) 
        {
            this.key = key;
            this.val = val;
        }
    }
    
    int capacity;
    LinkedList<Node> cache;
    HashSet<Integer> keySet;
    
    public LRUCache(int capacity) 
    {
        this.capacity = capacity;
        this.cache = new LinkedList<Node>();
        this.keySet = new HashSet<Integer>();
    }
    
    public int get(int key) 
    {
        // Empty cache
        if (cache.size() == 0)
            return -1;
        
        ListIterator<Node> i = cache.listIterator(0);
        while (i.hasNext())
        {
            Node target = i.next();

            // Found the node with the target key
            if (target.key == key)
            {
                i.remove();
                cache.addLast(target);
                return target.val;
            }
        }
        
        // Target key not in cache
        return -1;
    }
    
    public void put(int key, int value) 
    {
        Node newNode = new Node(key, value);
        
        // If key is already in cache, remove it
        if (keySet.contains(key))
        {   
            // Get the key so that it is at the end of the cache, then remove
            get(key);
            cache.removeLast();
        }
        
        // Cache is already full, so remove LRU node
        if (cache.size() == capacity)
        {   
            Node toRemove = cache.removeFirst();
            keySet.remove(toRemove.key);
            cache.addLast(newNode);
        }
        // Cache is not full, so we can just add it
        else
            cache.addLast(newNode);
        
        keySet.add(key);
    }
}