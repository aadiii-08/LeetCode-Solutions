class Solution {
    private int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        int lr = Integer.MIN_VALUE;
        int rr = Integer.MAX_VALUE;

        return insert(preorder, lr, rr);
    }

    TreeNode insert(int[] preorder, int lr, int rr){
        if(idx >= preorder.length || preorder[idx] < lr || preorder[idx] > rr){
            return null;
        }

        TreeNode node = new TreeNode(preorder[idx++]);
        node.left = insert(preorder, lr, node.val);
        node.right = insert(preorder, node.val, rr);

        return node;
    }
}