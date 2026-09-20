class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];

            adj.get(v).add(u);
            inDegree[u]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0) q.offer(i);
        }

        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            list.add(curr);
            for(int next : adj.get(curr)){
                inDegree[next]--;
                if(inDegree[next] == 0) q.offer(next);
            }
        }

        if(list.size() != numCourses) return new int[0]; 

        int[] ans = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}