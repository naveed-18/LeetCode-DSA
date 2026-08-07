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
    public int pairSum(ListNode head) {
        ListNode slow = getReverseHead (head);
        ListNode revHead = reverse (slow.next);
        slow.next = null;
        
        int maxSum = 0;
        ListNode curr1 = head;
        ListNode curr2 = revHead;

        while (curr1 != null && curr2 != null) {
            int sum = curr1.val + curr2.val;
            maxSum = Math.max(maxSum, sum);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return maxSum;
    }

    public ListNode getReverseHead (ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public ListNode reverse (ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode revHead = reverse (head.next);
        head.next.next = head;
        head.next = null;

        return revHead;
    }
}