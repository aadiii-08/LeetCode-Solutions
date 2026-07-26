class Solution {

    class Pair {
        TreeNode node;
        int idx;

        Pair(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!q.isEmpty()) {
            int n = q.size();

            int left = q.peek().idx;
            int right = left;

            for (int i = 0; i < n; i++) {
                Pair curr = q.poll();

                TreeNode node = curr.node;
                int idx = curr.idx;

                right = idx;

                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * idx + 1));
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, 2 * idx + 2));
                }
            }

            maxWidth = Math.max(maxWidth, right - left + 1);
        }

        return maxWidth;
    }
}