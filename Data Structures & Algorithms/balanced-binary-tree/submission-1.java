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
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
        //   height of the tree if it is balanced
        //   -1 if the tree is NOT balanced
    }

    public int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = getHeight(root.left);
        if (left == -1){ //If left subtree is already unbalanced, we don't need to continue checking
            return -1; //found an unbalanced subtree, so the entire tree above me is also unbalanced
        }

        int right = getHeight(root.right);
        if (right == -1){
            return -1;
        }

        if (Math.abs(left - right) > 1) { // If left and right subtree heights differ by more than 1, the current tree is unbalanced
            return -1; 
        }

        return 1 + Math.max(left,right);
    }
}

//Brute Force 
//Time Complexity: O(n)
//Space Complexity: O(n)

//My brute-force solution calculates the height separately and then recursively checks every subtree, which repeats work. I can optimize this by calculating the height and checking balance during the same DFS. If a subtree is unbalanced, I return -1 as a signal. Otherwise, I return its height. This allows every node to be processed once, giving O(n) time.


//DFS → get left height
//    → get right height
//    → check difference
//    → return height
//If unbalanced → return -1