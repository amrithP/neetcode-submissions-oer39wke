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

class Solution {
    public boolean hasCycle(ListNode head) {   
        //floyd warshall method

        ListNode slow = head;
        ListNode fast = head;

while( slow!=null && fast!=null && fast.next!=null ){
    slow=slow.next;
    fast = fast.next.next;

    if(slow == fast){
        return true;
    }
}

return false;    // tc is o(n) and sc is o(1)
        
    }
}
