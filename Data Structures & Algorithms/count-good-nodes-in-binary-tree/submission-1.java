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
class Pair{
    TreeNode current; 
    int max;
    public Pair(TreeNode current, int max){
        this.current = current;
        this.max = max;
    }
}
class Solution {

    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int goodNodes = 0; 
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, Integer.MIN_VALUE));
        while(!stack.isEmpty()){
            Pair current = stack.pop();
            if(current.current.val >= current.max){
                goodNodes++;
            }

            int newMax = Math.max(current.max, current.current.val);

            if(current.current.right != null){
                stack.push(new Pair(current.current.right, newMax));
            }
            if(current.current.left != null){
                stack.push(new Pair(current.current.left, newMax));
            }
        }
        return goodNodes;
    }
}
