/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, Integer.MIN_VALUE, Integer.MAX_VALUE});

        while (!queue.isEmpty()){
            Object[] entry = queue.poll();
            TreeNode node = (TreeNode) entry[0];
            int min = (int) entry[1];
            int max = (int) entry[2];

            // Node must be strictly inside its allowed range
            if (node.val <= min || node.val >= max){
                return false;
            }

            if (node.left != null){
                queue.offer(new Object[]{node.left, min, node.val});
            }
            if (node.right != null){
                queue.offer(new Object[]{node.right, node.val, max});
            }
        }

        return true;
    }
}

//BFS
//Time Complexity: O(n)
//Space Complexity: O(n)

//I queue each node paired with its valid min and max range. For each node I dequeue, I check if its value falls within the allowed range. When I enqueue the left child, the current node becomes the new upper bound. When I enqueue the right child, it becomes the new lower bound."
