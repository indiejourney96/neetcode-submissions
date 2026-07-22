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
        HashSet<ListNode> seen = new HashSet<>(); //Store all visited nodes (not value)

        ListNode cur = head; //Start from the head

        while (cur != null) {
            // Visited this node before -> cycle exists
            if (seen.contains(cur)){
                return true;
            }

            // Mark current node as visited 
            seen.add(cur);

            // Move to the next node 
            cur = cur.next;
        }
        return false; //Reached end of the list
    }
}

// I'll walk through the linked list while storing every visited node in a HashSet.
// If I ever encounter a node that's already in the set, then I've found a cycle. 
// Otherwise, if I reach null, the list has no cycle.