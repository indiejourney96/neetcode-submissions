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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        // If the tree is empty, return empty result immediately
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); // Start BFS with the root node

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            // IMPORTANT: capture q.size() BEFORE the loop
            // because q.size() changes as we add children inside the loop
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll(); // Remove the front node

                level.add(node.val); // Record this node's value

                // Add children for the NEXT level
                if (node.left != null)  q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            res.add(level); // All nodes at this level are collected
        }

        return res;
    }
}

//BFS
//Time Complexity: O(n)
//Space Complexity: O(n)

//I use BFS with a queue. I start by adding the root. Each iteration of the while loop processes one level — I capture the queue size before the loop starts so I know exactly how many nodes belong to the current level. I poll that many nodes, record their values, and add their children for the next level. I repeat until the queue is empty.
