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
    ListNode prev = null;
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int count = 0;
        ListNode temp = head;
        while (count < k && temp != null) { // reverse every k nodes.
            temp = temp.next;
            count++;
        }
        if (count < k) return head;
        ListNode newNode  = reverse(head, temp);
        head.next = reverseKGroup(temp, k);
        return newNode;
    }
    public ListNode reverse(ListNode start, ListNode end) {
        ListNode next;
        ListNode prev = null;
        while (start != end) {
            next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
        return prev;
    }
}