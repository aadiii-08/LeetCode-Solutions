class Solution {

    class Pair implements Comparable<Pair>{
        String video;
        int freq;
        Pair(String video, int freq){
            this.video = video;
            this.freq = freq;
        }

        public int compareTo(Pair that){
            if(this.freq == that.freq){
                return this.video.compareTo(that.video);
            }
            return this.freq - that.freq;
        }
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.offer(id);
        visited.add(id);
        int curLevel = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int currId = q.poll();
                for(int friend : friends[currId]){
                    if(!visited.contains(friend)){
                        visited.add(friend);
                        q.offer(friend);
                    }
                }
            }
            curLevel++;
            if(curLevel == level) break;
        }

        HashMap<String, Integer> freqMap = new HashMap<>();
        while(!q.isEmpty()){
            int currId = q.poll();
            for(String video : watchedVideos.get(currId)){
                freqMap.put(video, freqMap.getOrDefault(video, 0) + 1);
            }
        }

        List<Pair> videoList = new ArrayList<>();
        for(String video : freqMap.keySet()){
            videoList.add(new Pair(video, freqMap.get(video)));
        }

        Collections.sort(videoList);
        List<String> res = new ArrayList<>();
        for(Pair pair : videoList){
            res.add(pair.video);
        }

        return res;
    }
}