/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }else if(head.next==null){
            return null;
        }else{
            ListNode slow =head;
            ListNode fast = head;
            while(fast!=null && fast.next !=null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast==slow){
                slow = head;
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
            }
                return null;
        }
    }
}