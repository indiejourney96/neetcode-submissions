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
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0); // Start DFS from the root at depth 0
        return res;

    }

    private void dfs(TreeNode node, int depth){
        if (node == null) {
            return;
        }

        // If this is the first node at this depth,
        // create a new list for that level
        if (res.size() == depth) {
            res.add(new ArrayList<>());
        }

        // Add current node to its level
        res.get(depth).add(node.val);
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}

//DFS
//Time Complexity: O(n)
//Space Complexity: O(n)

//I'm using DFS and passing the current depth. Each depth corresponds to one list in the result, so when I first reach a new depth I create a list and add the node's value to that level.
