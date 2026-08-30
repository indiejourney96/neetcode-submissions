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
    public int goodNodes(TreeNode root) {
        int res = 0;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, Integer.MIN_VALUE));

        while (!queue.isEmpty()){
            Pair<TreeNode,Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int maxVal = pair.getValue();

            // Node is good if nothing above it on the path was larger
            if (node.val >= maxVal) res++;

            // Compute the new max once, reuse it for both children
            int newMax = Math.max(maxVal, node.val);
            if (node.left != null) queue.offer(new Pair<>(node.left, newMax));
            if (node.right != null) queue.offer(new Pair<>(node.right, newMax));
        }
        return res;
    }
}

//BFS
//Time Complextiy: O(n)
//Space Complexity: O(n)

//I use BFS, but instead of queuing just the node, I queue each node paired with the maximum value seen on the path from the root to that node — so I can check at each node whether it qualifies as good.
