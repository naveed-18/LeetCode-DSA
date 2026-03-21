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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode (-1);
        ListNode result = dummy;

        ListNode num1 = l1;
        ListNode num2 = l2;

        int carry = 0;
        while (num1 != null || num2 != null) {
            int add = 0;
            if (num1 != null && num2 != null) add = num1.val + num2.val + carry;
            else if (num1 == null) add = num2.val + carry;
            else add = num1.val + carry;

            ListNode node = new ListNode(add % 10);

            carry = add / 10;

            result.next =  node;
            result = result.next;

            num1 = num1 == null ? null : num1.next;
            num2 = num2 == null ? null : num2.next;
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            result.next =  node;
        }

        return dummy.next;
    }
}