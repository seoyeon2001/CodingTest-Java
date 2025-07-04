import java.util.*;

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;
        
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        // 첫번째 포함 안해
        dp1[1] = money[1];
        dp1[2] = Math.max(money[1], money[2]);
        for(int i = 3; i < n; i++) {
            dp1[i] = Math.max(dp1[i-1], (dp1[i-2] + money[i]));
        }
        
        // 첫번째 포함해 = 마지막 포함 안해
        dp2[0] = money[0];
        dp2[1] = dp2[0];
        for(int i = 2; i < n-1; i++) {
            dp2[i] = Math.max(dp2[i-1], (dp2[i-2] + money[i]));
        }
        
        // System.out.println(Arrays.toString(dp1));
        // System.out.println(Arrays.toString(dp2));
        return Math.max(dp1[n-1], dp2[n-2]);
    }
}