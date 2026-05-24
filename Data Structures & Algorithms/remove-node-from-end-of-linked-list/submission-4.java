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
        ListNode left = new ListNode(0, head);
        ListNode right = head;

        while(n > 0) {
            right = right.next;
            n--;
        }

        if (right == null) {
            return head.next;
        }

        while(right != null) {
            left = left.next;
            right = right.next;
        }
        
        left.next = left.next.next;
        return head;
    }
}
