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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); // Dummy node to build the result list
        ListNode cur = dummy; 

        int carry = 0; // Carry from the previous addition

        // Continue while there are digits to process
        // or we still have a carry
        while (l1 != null || l2 != null || carry != 0){
            int v1 = (l1 != null) ? l1.val : 0; 
            int v2 = (l2 != null) ? l2.val : 0;

            int sum = v1 + v2 + carry; 
            carry = sum / 10; // 15 / 10 = 1
            int digit = sum % 10; // 15 % 10 = 5
            cur.next = new ListNode(digit); // Add the sum to the result list

            cur = cur.next;
            l1 = (l1 != null) ? l1.next : null; // Move to the next nodes
            l2 = (l2 != null) ? l2.next : null;
        }
        return dummy.next;
    }
}
