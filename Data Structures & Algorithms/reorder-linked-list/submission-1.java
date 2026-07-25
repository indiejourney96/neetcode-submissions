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
    public void reorderList(ListNode head) {

        // -----------------------------
        // Step 1: Find the middle
        // -----------------------------
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // -----------------------------
        // Step 2: Reverse second half
        // -----------------------------
        ListNode second = slow.next;

        // Split the list into two halves
        ListNode prev = null;
        slow.next = null;

        while (second != null) {

            ListNode tmp = second.next;

            second.next = prev;

            prev = second;

            second = tmp;
        }

        // -----------------------------
        // Step 3: Merge the two halves
        // -----------------------------
        ListNode first = head;
        second = prev;

        while (second != null) {

            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            // Alternate nodes
            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }
}
