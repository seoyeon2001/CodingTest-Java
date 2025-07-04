import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        long[] dp = new long[stringToSec(play_time) + 1];
        int time = stringToSec(adv_time);
        
        for (String log : logs) {
            String[] a = log.split("-");
            int s = stringToSec(a[0]);
            int e = stringToSec(a[1]);
            
            dp[s]++;
            dp[e]--;
        }
        
        for(int i = 1; i < dp.length; i++) {
            dp[i] += dp[i-1];
        }
        for(int i = 1; i < dp.length; i++) {
            dp[i] += dp[i-1];
        }
        long max = dp[time-1];
        int result = 0;
        for (int i = 0; i < dp.length - time; i++) {
            if (dp[i+time]-dp[i] > max) {
                max = dp[i+time] - dp[i];
                result = i+1;
            }
        }
        
        return secToString(result);
    }
    
    int stringToSec(String str) {
        String[] a = str.split(":");
        return Integer.parseInt(a[0]) * 3600 + Integer.parseInt(a[1]) * 60 + Integer.parseInt(a[2]);
    }
    
    String secToString(int sec) {
        int h = sec / 3600;
        int m = sec % 3600 / 60;
        int s = sec % 3600 % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}