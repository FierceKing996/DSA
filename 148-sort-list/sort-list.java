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
    public ListNode mergell(ListNode ll1,ListNode ll2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(ll1!=null && ll2!= null){
            if(ll1.val<=ll2.val){
                temp.next = ll1;
                ll1 = ll1.next;
            }else{
                temp.next = ll2;
                ll2 = ll2.next;
            }
            temp=temp.next;
        }
        if(ll1!=null){
            temp.next = ll1;
        }else{
            temp.next = ll2;
        }

        return dummy.next;
    }
    public ListNode findMiddle(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast= fast.next.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
           return head;
       }
       ListNode middle = findMiddle(head);
       ListNode right = middle.next;
       middle.next = null;
       ListNode left = head;

       left = sortList(left);
       right = sortList(right);

       return mergell(left,right);
    }
}