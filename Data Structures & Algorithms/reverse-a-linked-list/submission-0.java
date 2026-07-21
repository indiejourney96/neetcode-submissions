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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;  // Previous node (starts as null because new tail points to null)
        ListNode curr = head;  // Current node we're processing

        while (curr != null){
            // Save the next node before breaking the link
            ListNode temp = curr.next;
            
            // Reverse the current node's pointer
            curr.next = prev;
            
            // Move both pointers one step forward
            prev = curr; 
            curr = temp;
        }
        return prev;
    }
}


//"I'll reverse the list one node at a time. For each node,
// I first save its next node so I don't lose the rest of the list. 
// Then I reverse its pointer to point to the previous node. 
// Finally, I move both pointers forward and repeat until I reach the end.