/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//find mid point, reverse the second half of the linked list and compare both halves 
class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null){
            return;
        }

    ListNode slow = head;
    ListNode fast = head;
    while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
    }
    ListNode previous  = null;
    while(slow!=null){
        ListNode next = slow.next;
        slow.next = previous;
        previous = slow;
        slow = next;
    }

    ListNode left = head;
    ListNode right = previous;


//the mid part is sent to last 
    while(right.next!=null){
      ListNode temp1 = left.next;
      ListNode temp2 = right.next;

        //first
        left.next = right;
        right.next = temp1;
//move the pointer 
 //  dont use this        // left = left.next;
        // right = right.next; //dont use this pls 
//move the pointer
        left = temp1;
        right = temp2;
    }

    }
}
