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
    public void dfs(TreeNode root,HashMap<TreeNode,TreeNode> map){
        if(root==null)return;
        if(root.left!=null)map.put(root.left,root);
        if(root.right!=null)map.put(root.right,root);
        dfs(root.left,map);
        dfs(root.right,map);
    }
    public void recurse(TreeNode node,int k , HashMap<TreeNode,TreeNode> map,int distance,Set<TreeNode> set,List<Integer> res){
        if(node==null || set.contains(node))return;
        set.add(node);
        
        if(distance==k){
            res.add(node.val);
            return;
        }
        recurse(node.left,k,map,distance+1,set,res);
        recurse(node.right,k,map,distance+1,set,res);
        recurse(map.get(node),k,map,distance+1,set,res);

    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        dfs(root,map);
        recurse(target,k,map,0,set,res);
        return res;
    }
}