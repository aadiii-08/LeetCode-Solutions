// approach 1 using priority queue -> get tle

// class Solution {
//     public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
//         int n = nums1.length;
//         PriorityQueue<Integer> pq = new PriorityQueue<>(
//             (a, b) -> Integer.compare(b, a)
//         );

//         for(int i = 0; i < n; i++){
//             int val = Math.abs(nums1[i] - nums2[i]);
//             if(val != 0){
//                 pq.offer(val);
//             }
//         }

//         long ans = 0;
//         int m = k1 + k2;
//         for(int i = 0; i < m; i++){
//             if(pq.isEmpty()) break;

//             int val = pq.poll() - 1;
//             if(val != 0){
//                 pq.offer(val);
//             }
//         }

//         while(!pq.isEmpty()){
//             int val = pq.poll();
//             ans += (long) val * val;
//         }

//         return ans;
//     }
// }



// approach 2
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] freq = new int[100001];

        for(int i = 0; i < n; i++){
            int diff = Math.abs(nums1[i] - nums2[i]);
            freq[diff]++;
        }

        int k = k1 + k2;
        for(int i = 100000; i > 0 && k > 0; i--){
            int ope = Math.min(freq[i], k);

            freq[i] -= ope;
            freq[i - 1] += ope;
            k -= ope;
        }
        long ans = 0;
        for(int i = 1; i <= 100000; i++){
            ans += ((long) freq[i] * i * i);
        }
        return ans;
    }
}