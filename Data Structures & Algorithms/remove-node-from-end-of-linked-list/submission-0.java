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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode Dummy = new ListNode();
        Dummy.next = head;   //connect to head 

        ListNode ptr1 = Dummy;
        ListNode ptr2 = Dummy;

        for(int i=0;i<n;i++){
            ptr2 = ptr2.next;
        }

        while(ptr2.next!=null){
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
           ptr1.next = ptr1.next.next;


           return Dummy.next;
    }
}
