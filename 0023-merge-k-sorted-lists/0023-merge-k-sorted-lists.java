/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];

        PriorityQueue<ListNode> queue = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.val, p2.val));
        for (ListNode n : lists) {
            if (n != null)
                queue.add(n);
        }

        ListNode head = new ListNode(0);
        ListNode current = head;
        while (!queue.isEmpty()) {
            current.next = queue.poll();
            current = current.next;
            if (current.next != null)
                queue.add(current.next);
        }

        return head.next;
    }
}