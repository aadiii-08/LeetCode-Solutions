class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int start=0;
        int end=0;
        int n = arr.length;
        int minLen=Integer.MAX_VALUE;
        int best[] = new int[n];
        Arrays.fill(best,Integer.MAX_VALUE);
        int sum=0;
        int ans=Integer.MAX_VALUE;
        while(end<n){
            //expand
            sum+=arr[end];
            end++;
            //shrink

            while(sum>target && start<end){
                sum-=arr[start];
                start++;
            }
            if(sum == target){
                int curLen = end-start;
                minLen = Math.min(minLen, curLen);
                //ans
                if(start>0 && best[start-1]!=Integer.MAX_VALUE){
                    ans = Math.min(ans, curLen + best[start-1]);
                }
            }
            best[end-1] = minLen;
        }
        return (ans==Integer.MAX_VALUE) ? -1 : ans;
    }
}