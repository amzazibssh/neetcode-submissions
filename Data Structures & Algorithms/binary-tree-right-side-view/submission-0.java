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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode firstRightNode = queue.poll(); 
            res.add(firstRightNode.val);
            int levelSize = queue.size();
            if(firstRightNode.right != null){
                queue.offer(firstRightNode.right);
            }
            if(firstRightNode.left != null){
                queue.offer(firstRightNode.left);
            }
            for (int i = 0; i < levelSize; i++){
                TreeNode current = queue.poll(); 
                if(current.right != null){
                    queue.offer(current.right);
                }
                if(current.left != null){
                    queue.offer(current.left);
                }
            }
                  
        }
        return res;
    }
}
