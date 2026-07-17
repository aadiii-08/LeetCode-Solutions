class Solution {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        update(root);
        return root;
    }

    public void update(TreeNode root){
        if(root == null) return;

        update(root.right);
        sum += root.val;
        root.val = sum;
        update(root.left);
        
    }
}