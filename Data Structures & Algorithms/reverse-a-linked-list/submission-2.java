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
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        return prev;        
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)

//"I'll reverse the list one node at a time. For each node,
// I first save its next node so I don't lose the rest of the list. 
// Then I reverse its pointer to point to the previous node. 
// Finally, I move both pointers forward and repeat until I reach the end.