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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;

        while (count++ < k) {
            if (curr == null) return head;
            curr = curr.next;
        }

        ListNode prevHead = reverseKGroup (curr, k);
        return revList (head, prevHead, k);
    }

    public ListNode revList (ListNode head, ListNode prevHead, int k) {
        ListNode curr = head;
        int count = 0;

        while (count++ < k) {
            ListNode currNext = curr.next;
            curr.next = prevHead;
            prevHead = curr;
            curr = currNext;
        }

        return prevHead;
    }
}