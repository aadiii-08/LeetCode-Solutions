class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        HashMap<Long, Integer> map = new HashMap<>();

        for(int num : nums){
            long val = num;
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int ans = 0;
        if(map.containsKey(1L)){
            int one = map.get(1L);
            ans = (one % 2 == 0) ? one - 1 : one;
            map.remove(1L);
        }

        for(long num : map.keySet()){
            int count = 0;

            long curr = num;

            while(map.containsKey(curr)){
                if(map.get(curr) >= 2){
                    count += 2;
                }else{
                    count++;
                    break;
                }
                curr = curr * curr;
            }

            if(count % 2 == 0){
                count--;
            }
            
            ans = Math.max(ans, count);
        }
        
        return ans;
    }
}