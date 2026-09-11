class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        int[] freq = new int[10];
        for(int digit : digits){
            freq[digit]++;
        }

        int count = 0;

        for(int i = 1; i <= 9; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k <= 8; k += 2){
                    // Temporarily use the digits
                    freq[i]--;
                    freq[j]--;
                    freq[k]--;

                    // If all frequencies are >= 0,
                    // the number can be formed
                    if (freq[i] >= 0 &&
                        freq[j] >= 0 &&
                        freq[k] >= 0) {
                        count++;
                    }

                    // Restore frequencies
                    freq[i]++;
                    freq[j]++;
                    freq[k]++;
                }
            }
        }
        return count;
    }
}