class Solution {
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++){
            for(int j = i + 1; j < V; j++){
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int d = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.get(i).add(new int[]{j,d});
                adj.get(j).add(new int[]{i,d});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] pair1, int[] pair2){
                return pair1[2] - pair2[2];
            }
        });

        int sum = 0;
        boolean[] visited = new boolean[V];
        pq.offer(new int[]{-1, 0, 0});

        while(!pq.isEmpty()){
            int[] object = pq.poll();
            int parent = object[0];
            int node = object[1];
            int weight = object[2];

            if(visited[node]) continue;

            visited[node] = true;

            if(parent != -1) sum += weight;

            for(int[] neighbourObject : adj.get(node)){
                int neighbourNode = neighbourObject[0];
                int neighbourWeight = neighbourObject[1];

                if(!visited[neighbourNode]){
                    pq.offer(new int[]{node, neighbourNode, neighbourWeight});
                }
            }
        }

        return sum;
    }
}