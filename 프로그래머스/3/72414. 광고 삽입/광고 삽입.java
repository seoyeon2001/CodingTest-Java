import java.util.*;
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSec = stringToSec(play_time);
        long[] dp = new long[playSec + 1];
        
        // 광고 길이
        int advSec = stringToSec(adv_time);
        
        // dp +1, -1 채우기
        for (String log : logs) {
            String[] startEnd = log.split("-");
            int s = stringToSec(startEnd[0]);
            int e = stringToSec(startEnd[1]);
            dp[s]++;
            dp[e]--;
        }
        
        // 해당 시점에 시청자 수 구하기
        for (int i = 1; i < dp.length; i++) {
            dp[i] += dp[i-1];
        }
        
        // 해당 시간까지의 누적합 구하기
        for (int i = 1; i < dp.length; i++) {
            dp[i] += dp[i-1];
        }
        
        // 구간의 최대 관객 수
        long max = dp[advSec-1];
        int result = 0;
        for (int i = 0; i < dp.length - advSec; i++) {
            if (dp[i+advSec]-dp[i] > max) {
                max = dp[i+advSec] - dp[i];
                result = i+1;
            }
        }
        
        return secToString(result);
    }
    
    static int stringToSec(String str) {
        String[] a = str.split(":");
        int h = Integer.parseInt(a[0]);
        int m = Integer.parseInt(a[1]);
        int s = Integer.parseInt(a[2]);
        return h*3600 + m*60 + s;
    }
    
    static String secToString(int sec) {
        int h = sec / 3600;
        String strH = isOne(h);
        int m = sec % 3600 / 60;
        String strM = isOne(m);
        int s = sec % 3600 % 60;
        String strS = isOne(s);
        return strH + ":" + strM + ":" + strS;
    }
    
    static String isOne(int num) {
        String s = Integer.toString(num);
        if (s.length() == 1) {
            return "0" + s;
        } else {
            return s;
        }
    }
}