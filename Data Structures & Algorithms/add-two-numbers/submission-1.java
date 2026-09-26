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


//Time Complexity: O(m + n)
//Space Complexity: 0(1) extra space, 0(max(m,n))
//where m = length of l1 and n = length of l2

//Because the digits are stored in reverse order, I can add the two lists from //head to tail just like normal addition. For each position, I add the two digits //and the carry. The current digit is sum % 10, and the carry is sum / 10. I use //a dummy node to build the result list

// dummy node
//     ↓
// get digit 1
// get digit 2
// add carry
//     ↓
// digit = sum % 10
// carry = sum / 10
//     ↓
// create node
// move pointers

