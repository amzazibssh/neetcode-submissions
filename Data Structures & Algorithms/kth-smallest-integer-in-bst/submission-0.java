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
    
    private void inorder(TreeNode root, List<TreeNode> listOfNodes) {
        if (root == null) return;

        inorder(root.left, listOfNodes);
        listOfNodes.add(root);
        inorder(root.right, listOfNodes);
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        List<TreeNode> listOfNodes = new ArrayList<>();
        inorder(root, listOfNodes);
        return listOfNodes.get(k - 1).val;
    }
}
