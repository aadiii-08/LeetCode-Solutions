class Solution {
    public boolean equationsPossible(String[] equations) {
        DisjointSet dsu = new DisjointSet(26);
        ArrayList<int[]> notEqualEdge = new ArrayList<>();
        for(String equation : equations){
            int u = equation.charAt(0) - 'a';
            int v = equation.charAt(3) - 'a';
            if(equation.charAt(1) == '='){
                dsu.unionBySize(u,v);
            }else{
                notEqualEdge.add(new int[]{u, v});
            }
        }

        for(int edge[] : notEqualEdge){
            int u = edge[0];
            int v = edge[1];
            if(dsu.findRootParent(u) == dsu.findRootParent(v)){
                return false;
            }
        }

        return true;
    }

    public class DisjointSet{
        int[] parent;
        int[] size;

        DisjointSet(int node){
            this.parent = new int[node];
            this.size = new int[node];
            for(int i = 0; i < node; i++){
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        public int findRootParent(int node){
            if(node == parent[node]){
                return node;
            }

            return findRootParent(parent[node]);
        }

        public boolean unionBySize(int node1, int node2){
            int rootParent1 = findRootParent(node1);
            int rootParent2 = findRootParent(node2);

            if(rootParent1 == rootParent2){
                return false;
            }

            if(size[rootParent1] < size[rootParent2]){
                parent[rootParent1] = rootParent2;
                size[rootParent2] += size[rootParent1];
            }else{
                parent[rootParent2] = rootParent1;
                size[rootParent1] += size[rootParent2];
            }
            return true;
        }
    }
}