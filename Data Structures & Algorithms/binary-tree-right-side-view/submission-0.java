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
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int depth){
        if (root == null){
            return;
        }

        //If this is the first node we see at this depth, it is the rightmost node cuz we visit right first
        if (res.size() == depth){
            res.add(root.val);
        }

        //Visit RIGHT child first
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }
}


//DFS
//Time complexity: O(n)
//Space complexity: O(n)

//I'll use DFS and visit the right child before the left child. This means that for each depth, the first node I encounter is the rightmost node at that level. I keep track of the current depth, and if the result list doesn't have a value for that depth yet, I add the current node.