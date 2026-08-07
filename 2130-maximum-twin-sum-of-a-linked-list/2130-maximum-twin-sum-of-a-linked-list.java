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
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }

        int[] nums = new int[n];
        int idx = 0;
        curr = head;
        while (curr != null) {
            nums[idx++] = curr.val;
            curr = curr.next;
        }

        int maxSum = 0;
        int i = 0, j = n - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            maxSum = Math.max(maxSum, sum);
            i++;
            j--;
        }

        return maxSum;
    }
}