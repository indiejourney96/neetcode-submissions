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
    public boolean hasCycle(ListNode head) {
        // Both pointers start at the head 
        ListNode slow = head; 
        ListNode fast = head; 

        // Fast needs at least one more node to move two steps
        while (fast != null && fast.next != null){

            // Slow moves one step 
            slow = slow.next; 

            // Fast moves two steps 
            fast = fast.next.next;

            // If they met, a cycle exists 
            if (slow == fast) {
                return true;
            }
        }
        return false; // Fast reached the end, so no cycle
    }
}

// I'll use two pointers. The slow pointer moves one node at a time, 
// while the fast pointer moves two nodes at a time. 
// If the list contains a cycle, 
// the faster pointer will eventually catch up to the slower pointer, 
// meaning both pointers will reference the same node. 
// If the fast pointer reaches the end of the list, then no cycle exists