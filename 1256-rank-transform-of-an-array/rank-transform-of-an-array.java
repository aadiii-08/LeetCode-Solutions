class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if (arr.length == 0) return new int[0];
        
        int[] copy = arr.clone();
        Arrays.sort(copy);
        Map<Integer,Integer> map = new HashMap<>();
        map.put(copy[0], 1);
        int rank = 1;

        for(int i = 1; i < n; i++){
            if(copy[i - 1] == copy[i]) continue;
            rank++;
            map.put(copy[i], rank);
        }

        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }
}