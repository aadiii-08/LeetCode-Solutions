class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < isConnected[i].length; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int provinces = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(i, adj, vis);
                provinces++;
            }
        }

        return provinces;
    }

    public void dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[src] = true;

        for(int neighbour : adj.get(src)){
            if(!vis[neighbour]){
                dfs(neighbour, adj, vis);
            }
        }
    }
}