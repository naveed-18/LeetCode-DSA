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
    public ListNode partition(ListNode head, int x) {
        ListNode lessThanX = new ListNode(-1);
        ListNode greatThanX = new ListNode(-1);

        ListNode lessCurr = lessThanX;
        ListNode greatCurr = greatThanX;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                lessCurr.next = curr;
                lessCurr = lessCurr.next;
            } else {
                greatCurr.next = curr;
                greatCurr = greatCurr.next;
            }
            curr = curr.next;
        }

        lessCurr.next = greatThanX.next;
        greatCurr.next = null;
        return lessThanX.next;
    }
}