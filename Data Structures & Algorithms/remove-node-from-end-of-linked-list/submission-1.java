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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Dummy node handles removing the head easily
        ListNode dummy = new ListNode(0, head);

        ListNode left = dummy;
        ListNode right = head;

        // Move right pointer n steps ahead
        while (n > 0) {
            right = right.next;
            n--;
        }

        // Keep moving both pointers until right reaches the end
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        // Skip the node to remove
        left.next = left.next.next;

        return dummy.next;
    }
}

// Time complexity: O(N)
// Space complexity: O(1)


// I'll use two pointers with a gap of n nodes. 
// I use a dummy node so the same logic also works when the head itself needs to be removed.
// First, I move the right pointer n steps ahead. 
// Then I move both pointers together until the right pointer reaches the end. 
// At that point, the left pointer is just before the node that needs to be removed, 
// so I skip it by updating left.next. 

