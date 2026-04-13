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
//  APPROACH 1:
// PriorityQueue<Integer> minHeap = new PriorityQueue<>();
// for(ListNode nums : lists) {
//     while(nums != null) {
//         minHeap.add(nums.val);
//         nums = nums.next;
//     }
// }
// ListNode ans = new ListNode(-1);
// ListNode temp = ans;
// while(!minHeap.isEmpty()) {
//     ListNode currNode = new ListNode(minHeap.poll());
//     temp.next = currNode;
//     temp = currNode;
// }
// return ans.next;
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //APPROACH 2
        Queue<ListNode> queue = new LinkedList<>();
        for(ListNode list : lists) queue.offer(list);
        while(queue.size() > 1) {
            ListNode first = queue.poll();
            ListNode second = queue.poll();
            ListNode merge = merged(first, second);
            queue.offer(merge);
        }
        return queue.poll();
    }
    public ListNode merged(ListNode first, ListNode second) {
        ListNode ans = new ListNode(-1);
        ListNode curr = ans;
        while(first != null && second != null) {
            if(first.val <= second.val) {
                curr.next = first;
                first = first.next;
            } else {
                curr.next = second;
                second = second.next;
            }
            curr = curr.next;
        }
        if(first != null) curr.next = first;
        if(second != null) curr.next = second;
        return ans.next;
    }
}