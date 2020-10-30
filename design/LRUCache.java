// https://leetcode.com/problems/lru-cache/

import java.util.*;

public class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    
    public void add(Node n) {
        // Connect n in between head and head.next
        n.prev = head;
        n.next = head.next;
        
        // Adjust head.next
        head.next.prev = n;
        head.next = n;
    }
    
    public void remove(Node n) {
        // Save previous and next nodes
        Node prev = n.prev;
        Node next = n.next;
        
        // Adjust pointers
        prev.next = next;
        next.prev = prev;
    }
    
    public void moveToHead(Node n) {
        remove(n);
        add(n);
    }
    
    public Node pollLast() {
        Node result = tail.prev;
        remove(result);
        return result;
    }    
    
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> keyToNode;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyToNode = new HashMap<>();
        
        // Initialize dummy head and tail
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        
        // Dummy head and tail point at each other
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        // Node is not in the list
        if (!keyToNode.containsKey(key)) {
            return -1;
        }
        
        Node n = keyToNode.get(key);
        moveToHead(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if (!keyToNode.containsKey(key)) {
            // Remove tail if over capacity
            if (keyToNode.size() >= capacity) {
                Node removed = pollLast();
                keyToNode.remove(removed.key);
            }
            
            // Add new node to list and map
            Node newNode = new Node(key, value);
            keyToNode.put(key, newNode);
            add(newNode);   
        } else {
            // If key is already in map, just update the value
            Node n = keyToNode.get(key);
            n.val = value;
            moveToHead(n);
        }
    }
}