class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        // Dummy node points to the beginning of the list
        // and makes reconnecting groups easier
        ListNode dummy = new ListNode(0, head);

        // Node immediately before the current group
        ListNode groupPrev = dummy;

        while (true) {

            // Find the kth node in the current group
            ListNode kth = getKth(groupPrev, k);

            // Not enough nodes left → leave them unchanged
            if (kth == null) {
                break;
            }

            // Save the first node AFTER the group 
            ListNode groupNext = kth.next;

            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {

                // Save next node before changing the pointer
                ListNode tmp = curr.next;

                // Reverse the pointer
                curr.next = prev;

                // Move forward
                prev = curr;
                curr = tmp;
            }

            // Save old first node (it becomes the group's last node)
            ListNode tmp = groupPrev.next;
            // Connect previous part to the new first node
            groupPrev.next = kth;
            // Move groupPrev to the end of the reversed group
            groupPrev = tmp;
        }

        return dummy.next;
    }

    // Find the kth node starting from groupPrev
    private ListNode getKth(ListNode curr, int k) {

        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        return curr;
    }
}

//Time Complexity: O(n)
//Space Complexity: 0(1)


// I use a dummy node so that every group can be handled in the same way.
// For each group, I first find the kth node. If there are fewer than k
// nodes remaining, I leave those nodes unchanged.
// I then reverse the group using the normal linked-list reversal technique.
// The difference is that prev starts at groupNext instead of null, because
// the reversed group needs to connect to the rest of the list.
// After reversing, kth becomes the first node of the group, while the old
// first node becomes the last node. I reconnect the group and repeat.


            //1 → 2 → 3 | 4 → 5
            //    GROUP    NEXT
            
            //3 → 2 → 1 | 4 → 5
            //    GROUP    NEXT
            // Reverse the group

            //prev = 4
            //curr = 1
            //1 → 2 → 3 → 4 → 5