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

        // Empty list
        if (head == null) {
            return;
        }

        // Store every node for easy random access
        List<ListNode> nodes = new ArrayList<>();

        ListNode cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }

        // Two pointers from the front and back
        int i = 0;
        int j = nodes.size() - 1;

        while (i < j) {

            // Connect front node to back node
            nodes.get(i).next = nodes.get(j);
            i++;

            // Stop if pointers meet
            if (i >= j) {
                break;
            }

            // Connect back node to next front node
            nodes.get(j).next = nodes.get(i);
            j--;
        }

        // End the list
        nodes.get(i).next = null;
    }
}


// Time complexity: 
// O(n)
// Space complexity: 
// O(n)

// I'll first traverse the linked list and store every node in an ArrayList. 
// This allows me to access both the first and last nodes in O(1) time. 
// Then I'll use two pointers, one from the beginning and one from the end of the list, alternately connecting nodes until the pointers meet. 
// Finally, I'll set the last node's next pointer to null to terminate the reordered list.