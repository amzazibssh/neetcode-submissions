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
    class Range{
        int min;
        int max;
        TreeNode current;
        public Range(int min, int max, TreeNode current){
            this.min = min; 
            this.max = max;
            this.current = current;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<Range> stack = new Stack<>();
        stack.push(new Range(Integer.MIN_VALUE, Integer.MAX_VALUE, root));
        while(!stack.isEmpty()){
            Range current = stack.pop();

            if(current.current.val >= current.max || current.current.val <= current.min){
                return false;
            }
            if(current.current.right != null){
                int newMin = current.current.val;
                stack.push(new Range(newMin, current.max, current.current.right)); 
            }
            if(current.current.left != null){
                int newMax = current.current.val;
                stack.push(new Range(current.min, newMax, current.current.left)); 
            }
        }
        return true;
    }
}
