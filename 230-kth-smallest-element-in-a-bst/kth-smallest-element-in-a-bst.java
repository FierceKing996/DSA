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
    public void inorder(TreeNode root,List<Integer> nodes){
        if(root==null)return;
        inorder(root.left,nodes);
        nodes.add(root.val);
        inorder(root.right,nodes);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nodes = new ArrayList<>();
        inorder(root,nodes);
        Collections.sort(nodes);
        return nodes.get(k-1);
    }
}