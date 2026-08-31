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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        dfs(root, arr);

        // List is 0-indexed, k is 1-indexed, so subtract 1
        return arr.get(k - 1);
    }

    public void dfs(TreeNode node, List<Integer> arr){
        if (node == null){
            return ;
        }
        dfs(node.left, arr); // visit left subtree first (smaller values)
        arr.add(node.val);  // record this node AFTER left is fully done
        dfs(node.right, arr); // visit right subtree last (larger values)
    }
}

//Inorder Traversal 
//Time:  O(N) — visits every node
//Space: O(N) — stores every value in the list

//So I collect all values into a list using in-order traversal, then return the element at index k minus 1.
