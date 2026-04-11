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
        return removeNthFromEndWithDummy(head, n);
    } 

    public ListNode removeNthFromEndWithDummy(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        while (n-- >= 0) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    } 

    public ListNode removeNthFromEndNoDummy(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }

        if (fast == null) return head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        
        return head;
    }
}