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
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int depth){
        if (root == null){
            return ;
        }

        if (res.size() ==depth){
            res.add(new ArrayList<>());
        }

        res.get(depth).add(root.val);

        if (root.left != null){
            dfs(root.left, depth + 1);
        }

        if (root.right != null){
            dfs(root.right, depth + 1);
        }
    }
}
