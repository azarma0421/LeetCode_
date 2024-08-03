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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode newNode = reverList(head);

        ListNode preNode = new ListNode(0);
        preNode.next = newNode;
        newNode = preNode;
        ListNode thisNode = newNode.next;

        for (int i = 0 ; i < n ; i++) {
            if (i == n - 1) {
                preNode.next =thisNode.next;
                
            }else{
                preNode = thisNode;
                thisNode = thisNode.next;
            }

        }
        
        ListNode ansNode = reverList(newNode.next);
        return ansNode;
    }

    private ListNode reverList(ListNode head) {
        if(head == null) return head;
        ListNode newNode = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            ListNode current = new ListNode(head.val);
            current.next = newNode;
            newNode = current;
            head = head.next;
        }
        return newNode;
    }
}