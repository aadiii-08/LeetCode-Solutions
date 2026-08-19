class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for(int num : piles){
            right = Math.max(right, num);
        }
        int ans = 0;
        while(left < right){
            int mid = left + (right - left) / 2;

            if(canEat(piles, h, mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return left;
    }

    boolean canEat(int[] piles, int h, int mid){
        int takenTime = 0;

        for(int pile : piles){
            takenTime += pile / mid;

            if(pile % mid != 0){
                takenTime++;
            }
        }

        return takenTime <= h;
    }
}