// https://leetcode.com/problems/design-linked-list/

public class MyLinkedList 
{
    // Auxiliary node class used by the linked list class
    public class ListNode 
    {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    // Constructor
    ListNode head;
    public MyLinkedList() 
    {
        head = null;
    }
    
    // Get the value of the index-th node in the linked list. If the index is invalid, return -1
    public int get(int index) 
    {
        // Invalid index
        if (index >= getListLength())
            return -1;
        
        ListNode currNode = head;
        for (int i = 0; i < index; i++) 
            currNode = currNode.next;
        
        return currNode.val;
    }
    
    /* Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) 
    {
        ListNode newNode = new ListNode(val);
        if (head != null)
            newNode.next = head;
        head = newNode;
    }
    
    // Append a node of value val to the last element of the linked list.
    public void addAtTail(int val) 
    {
        ListNode newNode = new ListNode(val);
        ListNode currNode = head;
        
        // Edge case where head is null
        if (currNode == null)
        {
            head = newNode;
            return;
        }
        
        while (currNode.next != null)
            currNode = currNode.next;
        
        currNode.next = newNode;
    }
    
    // Get the length of the linked list
    public int getListLength()
    {
        int listLength = 0;
        ListNode currNode = head;
        while (currNode != null)
        {
            listLength++;
            currNode = currNode.next;
        }
        
        return listLength;
    }
    
    /* Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) 
    {
        // Adding at index 0 is the same as adding to the head
        if (index == 0)
        {
            addAtHead(val);
            return;
        }
        /* Adding at the index equal to the list length 
           is the same as adding to the tail */
        else if (index == getListLength())
        {
            addAtTail(val);
            return;
        }
        // Invalid index
        else if (index > getListLength())
            return;
        
        ListNode prevNode = null;
        ListNode currNode = head;
        for (int i = 0; i < index; i++)
        {
            prevNode = currNode;
            currNode = currNode.next;
        }
        
        ListNode newNode = new ListNode(val);
        newNode.next = currNode;
        prevNode.next = newNode;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) 
    {
        // Just need to change the head
        if (index == 0)
        {
            head = head.next;
            return;
        }
        // Invalid index
        else if (index >= getListLength())
            return;
        
        ListNode prevNode = null;
        ListNode currNode = head;
        
        for (int i = 0; i < index; i++)
        {
            prevNode = currNode;
            currNode = currNode.next;
        }
        
        prevNode.next = currNode.next;
    }
}