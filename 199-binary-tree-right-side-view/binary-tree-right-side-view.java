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
    public List<Integer> recursion(TreeNode root,int level,List<Integer> result){
        if(root==null)return null;
        if(result.size()==level)result.add(root.val);
         recursion(root.right,level+1,result);
        recursion(root.left,level+1,result);
        return result;
       
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)return new ArrayList<>();
        return recursion(root,0,new ArrayList<>());
        
    }
}