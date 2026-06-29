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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
         return mergeHelper(lists,0,lists.length-1);
    }

    public ListNode mergeHelper(ListNode[] lists,int start,int end){
        if(start == end){   //only one list exists
         return lists[start];
        }
        if(start+1 == end){   //exactly 2
          return mergeTwoLists(lists[start],lists[end]);
        }
        
        // divide n conquer ,  recursion , binary search
         int mid = start + (end-start)/2;
         ListNode left  = mergeHelper(lists,start,mid);
         ListNode  right =  mergeHelper(lists,mid+1,end);
         return mergeTwoLists(left,right);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode  result = new ListNode();
        ListNode  curr = result;

        while(l1!= null && l2!=null){
            if(l1.val<=l2.val){
                curr.next = l1;
                l1=l1.next;
            }
            else{
                curr.next = l2;
                l2=l2.next;
            }
            curr = curr.next;
        }
      
      if(l1==null){
        curr.next=l2;
      }
      if(l2==null){
        curr.next =l1;
      }

      return result.next;
    }
}
