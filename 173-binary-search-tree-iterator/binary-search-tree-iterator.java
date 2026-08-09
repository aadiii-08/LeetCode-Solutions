class BSTIterator {
    Queue<Integer> q;

    void inorder(TreeNode root, Queue<Integer> q){
        if(root == null) return;

        inorder(root.left, q);
        q.offer(root.val);
        inorder(root.right, q);
    }

    public BSTIterator(TreeNode root) {
        q = new LinkedList<>();
        inorder(root, q);
    }

    public int next() {
        return q.poll();
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
}