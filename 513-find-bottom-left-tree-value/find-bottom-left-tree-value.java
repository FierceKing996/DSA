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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode ans = root ;
        if(root==null)return 0;
        while(!q.isEmpty()){
            ans=q.poll();
            if(ans.right!=null)q.offer(ans.right);
            if(ans.left!=null)q.offer(ans.left);        
        }
        return ans.val;
    }
}