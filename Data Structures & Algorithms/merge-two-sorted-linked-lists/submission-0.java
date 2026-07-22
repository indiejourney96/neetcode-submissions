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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Dummy node simplifies building the merged list 
        ListNode dummy = new ListNode(0);
        // Points to the last node in the merged list
        ListNode node = dummy; 

        // Compare nodes from both lists
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val){

                // Attach the smaller node
                node.next = list1;

                // Move list1 forward 
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next; //Move to the newly added node
        }

        // Attach whichever list still has remaining nodes
        if (list1 != null){
            node.next = list1;
        } else if (list2 != null){
            node.next = list2;
        }
        //Skip the dummy node
        return dummy.next;
    }
}

// I create a dummy node so I don't need to handle the head of the merged. 
// I keep a pointer to the end of the merged list. 
// While both input lists have nodes, I compare their current values, 
// attach the smaller node, and advance the corresponding pointer.
// After one list is exhausted, 
// I simply attach the remaining nodes from the other list, since they are already sorted. 
// Finally, I return dummy.next, which is the real head of the merged list.