class Solution {
    public int maxConsistentColumns(int[][] grid, int limit) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        int ans = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                boolean check = true;
                for(int k = 0; k < m; k++){
                    if(Math.abs(grid[k][i] - grid[k][j]) > limit){
                        check = false;
                        break;
                    }
                }
                if(check && arr[j] + 1 > arr[i]){
                    arr[i] = arr[j] + 1;
                }
            }
            ans = Math.max(ans, arr[i]);
        }
        return ans;
    }
}