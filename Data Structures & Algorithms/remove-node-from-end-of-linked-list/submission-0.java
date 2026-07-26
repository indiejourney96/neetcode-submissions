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
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;

        while (cur != null){
            nodes.add(cur); 
            cur = cur.next;
        }

        int removeIndex = nodes.size() - n; // Find the index of the node to remove
        if (removeIndex == 0){
            return head.next; // Removing the head node, so return the second node as the new head
        }

        // Skip the node to remove by linking the previous node
        // directly to the next node
        nodes.get(removeIndex - 1).next = nodes.get(removeIndex).next;
        return head;
    }
}

// Time complexity: O(N)
// Space complexity: O(N)

