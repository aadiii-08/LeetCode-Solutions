class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        boolean[] vis = new boolean[n];
        vis[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty()){
            int front = q.poll();
            for(int ele : rooms.get(front)){
                if(!vis[ele]){
                    q.offer(ele);
                    vis[ele] = true;
                }
            }
        }

        for(boolean flag : vis){
            if(!flag) return false;
        }

        return true;
    }
}