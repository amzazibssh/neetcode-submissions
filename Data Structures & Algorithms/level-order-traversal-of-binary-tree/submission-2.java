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
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> currentList = new ArrayList<>();
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                TreeNode current = queue.poll();
                currentList.add(current.val);
                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
            }
            
        
        res.add(currentList);       
        }
        return res;
    }
}
