class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int startSec = 0;
        int endSec = 0;

        startSec += Integer.parseInt(startTime.substring(0, 2)) * 3600;
        startSec += Integer.parseInt(startTime.substring(3, 5)) * 60;
        startSec += Integer.parseInt(startTime.substring(6, 8));

        endSec += Integer.parseInt(endTime.substring(0, 2)) * 3600;
        endSec += Integer.parseInt(endTime.substring(3, 5)) * 60;
        endSec += Integer.parseInt(endTime.substring(6, 8));

        return endSec - startSec;
    }
}