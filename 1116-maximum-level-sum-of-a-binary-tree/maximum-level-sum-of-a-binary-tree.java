class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue <TreeNode> q = new LinkedList<>();

        int max = root.val;
        int level = 0;
        int ans = 1;

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            level++;

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                sum += curr.val;
                
                if(curr.left != null){
                    q.offer(curr.left);
                }

                if(curr.right != null){
                    q.offer(curr.right);
                }
            }

            if(sum > max){
                max = sum;
                ans = level;
            }
        }

        return ans;
    }
}