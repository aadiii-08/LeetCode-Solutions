class Solution {
    int time;
    int[] dt;
    int[] low;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        time = 0;
        dt = new int[n];
        low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dt[i] == 0) {
                dfs(i, -1, adj, bridges);
            }
        }

        return bridges;
    }

    public void dfs(int u, int parU, ArrayList<ArrayList<Integer>> adj, List<List<Integer>> bridges) {
        time++;
        dt[u] = time;
        low[u] = time;

        for (int v : adj.get(u)) {
            if (dt[v] == 0) {
                dfs(v, u, adj, bridges);
                // update low
                low[u] = Math.min(low[u], low[v]);

                // bridge
                if (low[v] > dt[u]) {
                    bridges.add(Arrays.asList(u, v));
                }
            } else if (v != parU) {
                low[u] = Math.min(low[u], dt[v]);
            }
        }
    }
}