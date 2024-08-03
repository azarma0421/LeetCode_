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
        if (lists.length == 0 || lists == null) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode n : lists){
            if(n != null)
                minHeap.offer(n);
        }
        
        ListNode mergeList = new ListNode(0);
        ListNode currentNode = mergeList;
        while(!minHeap.isEmpty()){
            ListNode minNode = minHeap.poll();
            if(minNode.next != null){
                minHeap.offer(minNode.next);
            }
            currentNode.next = minNode;
            currentNode =currentNode.next;
        }

        return mergeList.next;
    }
}