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
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        // BFS: process the tree level by level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            //Swap the left to the right
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // Add children to the queue for later processing
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return root; 
    }
}


//Breath-search first 
//Time Complexity : O(n)
//Space Complexity : O(n)

/*
Interview explanation:

"I use BFS to visit every node in the tree.
For each node, I swap its left and right children.
Then I add its children to the queue so they can also be inverted.

I continue until the queue is empty.

Since every node is visited once, the time complexity is O(n).
The queue can contain up to O(n) nodes, so the space complexity is O(n)."
*/