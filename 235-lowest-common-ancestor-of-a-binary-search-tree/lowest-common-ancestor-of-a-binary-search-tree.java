/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public boolean path(TreeNode root,TreeNode p,List<TreeNode> path){
        if(root==null)return false;
        path.add(root);
        if(root==p) return true;
        if (path(root.left, p, path) || path(root.right, p, path)) {
        return true;
        }
        path.remove(path.size() - 1);

        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> plist = new ArrayList<>();
        List<TreeNode> qlist = new ArrayList<>();  
        path(root,p,plist);
        path(root,q,qlist);
        TreeNode ans=null;
        int n = Math.min(plist.size(), qlist.size());
        for (int i = 0; i < n; i++) {
            if (plist.get(i) == null || qlist.get(i) == null) {
                break; // stop if either list has null
            }
            if (!plist.get(i).equals(qlist.get(i))) {
                break; // mismatch found, stop
            }
            ans = plist.get(i); // update last common element
        }
        return ans;
    }
}