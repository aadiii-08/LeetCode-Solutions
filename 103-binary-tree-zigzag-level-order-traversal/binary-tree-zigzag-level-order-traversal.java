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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        boolean check = true;
        while(!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> list = new LinkedList<>();

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();

                if(check){
                    list.addLast(curr.val);
                }else{
                    list.addFirst(curr.val);
                }

                if(curr.left != null){
                    q.offer(curr.left);
                }

                if(curr.right != null){
                    q.offer(curr.right);
                }
            }

            ans.add(list);
            check = !check;
        }

        return ans;
    }
}