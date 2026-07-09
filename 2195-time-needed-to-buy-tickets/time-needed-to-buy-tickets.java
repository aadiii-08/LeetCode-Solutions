class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.offer(i);
        }

        int time = 0;

        while (!q.isEmpty()) {
            time++;
            int front = q.poll();
            tickets[front]--;
            
            if (k == front && tickets[front] == 0) {
                return time;
            }
            if (tickets[front] != 0) {
                q.offer(front);
            }
        }

        return time;
    }
}