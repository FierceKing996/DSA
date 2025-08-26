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
class BSTIterator {
    int i =-1;
    List<Integer> order = new ArrayList<>();
    public void inorder(TreeNode root,List<Integer> order){
        if(root==null)return;
        inorder(root.left,order);
        order.add(root.val);
        inorder(root.right,order);
    }
    public BSTIterator(TreeNode root) {
        inorder(root,order);
    }
    
    public int next() {
        i++;
        return order.get(i);
    }
    
    public boolean hasNext() {
        if(i==order.size()-1)return false;
        if(order.get(i+1)!=null)return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */